@file:OptIn(ExperimentalCoroutinesApi::class)

package com.gahov.prweather.data.repository

import android.content.SharedPreferences
import com.gahov.prweather.data.local.entities.WeatherDTO
import com.gahov.prweather.data.local.storage.authorization.ImplAuthorizationLocalStorage
import com.gahov.prweather.data.local.storage.weather.WeatherDao
import com.gahov.prweather.data.mapper.weather.local.WeatherDomainToLocalMapper
import com.gahov.prweather.data.mapper.weather.remote.WeatherResponseToDomainMapper
import com.gahov.prweather.data.remote.configuration.interceptor.utils.token.BearerProvider
import com.gahov.prweather.data.remote.configuration.interceptor.utils.token.TokenProvider
import com.gahov.prweather.data.remote.protocol.WeatherProtocol
import com.gahov.prweather.data.remote.url.BaseUrlProvider
import com.gahov.prweather.data.repository.weather.ImplWeatherRepository
import com.gahov.prweather.data.source.auth.TokenSource
import com.gahov.prweather.data.source.auth.impl.ImplTokenSource
import com.gahov.prweather.data.source.weather.local.ImplWeatherLocalSource
import com.gahov.prweather.data.source.weather.local.WeatherLocalSource
import com.gahov.prweather.data.source.weather.remote.ImplWeatherRemoteSource
import com.gahov.prweather.data.source.weather.remote.WeatherRemoteSource
import com.gahov.prweather.data.test.base.BaseTest
import com.gahov.prweather.data.test.base.file.FileReader.Companion.ERROR_CITY_NOT_FOUND_404_MOCK
import com.gahov.prweather.data.test.base.file.FileReader.Companion.ERROR_UNAUTHORIZED_401_MOCK
import com.gahov.prweather.data.test.base.file.FileReader.Companion.SUCCESS_200_MOCK
import com.gahov.prweather.data.test.base.retrofit.RetrofitHelper
import com.gahov.prweather.domain.entities.common.Either
import com.gahov.prweather.domain.entities.failure.ServerError
import com.gahov.prweather.domain.repository.weather.WeatherRepository
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Spy
import org.mockito.kotlin.whenever
import java.net.HttpURLConnection

@OptIn(ExperimentalCoroutinesApi::class)
class WeatherRepositoryTest : BaseTest() {

    override var useMockServer: Boolean = true

    private lateinit var protocol: WeatherProtocol

    private lateinit var repository: WeatherRepository

    private lateinit var remoteSource: WeatherRemoteSource

    private lateinit var tokenProvider: TokenProvider

    private lateinit var tokenSource: TokenSource

    private lateinit var localSource: WeatherLocalSource

    @Mock
    private lateinit var weatherDao: WeatherDao

    @Spy
    private val remoteMapper: WeatherResponseToDomainMapper = WeatherResponseToDomainMapper()

    @Spy
    private val localMapper: WeatherDomainToLocalMapper = WeatherDomainToLocalMapper()


    override fun setUp() {
        super.setUp()
        protocol = RetrofitHelper.testApiInstance(
            localServerUrl = mockWebServer.url("/").toString(),
            networkServerUrl = BaseUrlProvider.BASE_URL,
            useRealRequests = !useMockServer
        )
        val sharedPrefs: SharedPreferences = Mockito.mock(SharedPreferences::class.java)

        tokenSource =
            ImplTokenSource(storage = ImplAuthorizationLocalStorage(preferences = sharedPrefs))
        tokenProvider = BearerProvider(tokenSource = tokenSource)
        remoteSource = ImplWeatherRemoteSource(
            protocol = protocol,
            tokenProvider = tokenProvider
        )
        localSource = ImplWeatherLocalSource(
            weatherDao = weatherDao
        )
        repository = ImplWeatherRepository(
            remoteSource = remoteSource,
            localSource = localSource,
            weatherRemoteMapper = remoteMapper,
            weatherLocalMapper = localMapper
        )
    }

    @Test
    fun `for success city weather load local`() = runTest {
        whenever(weatherDao.select()).thenReturn(listOf<WeatherDTO>())

        val actualResult = repository.getCitiesWeatherList()
        val data = (actualResult as? Either.Right)?.success

        assertThat(actualResult.isRight).isTrue()
        assertThat(data != null).isTrue()
    }

    @Test
    fun `for success city weather load remote`() = runTest {
        enqueueData(generateSuccessResponse(fileReader.loadJsonAsString(SUCCESS_200_MOCK)))

        val actualResult = repository.loadRemoteCityWeatherByName(cityName = TEST_CITY_NAME)
        val data = (actualResult as? Either.Right)?.success

        assertThat(actualResult.isRight).isTrue()
        assertThat(data != null).isTrue()
        assertThat(data?.cityName == TEST_CITY_NAME)
    }

    @Test
    fun `for unauthorized response result`() = runTest {
        enqueueData(generateFailureResponse(fileReader.loadJsonAsString(fileName = ERROR_UNAUTHORIZED_401_MOCK)))

        val actualResult = repository.loadRemoteCityWeatherByName(cityName = TEST_CITY_NAME)
        val data = (actualResult as? Either.Left)?.failure

        assertThat(actualResult.isLeft).isTrue()
        assertThat(data).isInstanceOf(ServerError.ServerCodeError::class.java)
    }

    @Test
    fun `for city not found response result`() = runTest {
        enqueueData(
            generateFailureResponse(
                body = fileReader.loadJsonAsString(fileName = ERROR_CITY_NOT_FOUND_404_MOCK),
                error = HttpURLConnection.HTTP_NOT_FOUND
            )
        )

        val actualResult = repository.loadRemoteCityWeatherByName(cityName = WRONG_TEST_CITY_NAME)
        val data = (actualResult as? Either.Left)?.failure

        assertThat(actualResult.isLeft).isTrue()
        assertThat(data).isInstanceOf(ServerError.ServerCodeError::class.java)
    }

    @Test
    fun `for delete city data by name`() = runTest {
        repository.deleteLocalCity(TEST_CITY_NAME)
        Mockito.verify(weatherDao).deleteWeatherDataByCityName(TEST_CITY_NAME)
    }

    companion object {
        const val TEST_CITY_NAME = "Vienna"
        const val WRONG_TEST_CITY_NAME = "WrongCityName"
    }
}