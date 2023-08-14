package com.gahov.prweather.domain.usecase

import com.gahov.prweather.domain.entities.common.Either
import com.gahov.prweather.domain.entities.weather.CityWeatherParams
import com.gahov.prweather.domain.entities.weather.WeatherEntity
import com.gahov.prweather.domain.repository.weather.WeatherRepository
import com.gahov.prweather.domain.usecase.weather.LoadRemoteCityWeatherUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@OptIn(ExperimentalCoroutinesApi::class)
class LoadRemoteCityWeatherUseCaseTest  {

    @Mock
    private lateinit var mockRepository: WeatherRepository

    private lateinit var loadRemoteCityWeatherUseCase: LoadRemoteCityWeatherUseCase

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        loadRemoteCityWeatherUseCase = LoadRemoteCityWeatherUseCase(mockRepository)
    }

    @Test
    fun `execute should return the result from repository`() = runTest {
        val cityName = "Vienna"
        val weatherEntity = WeatherEntity(cityName = cityName)
        val expectedResult = Either.Right(weatherEntity)

        Mockito.`when`(mockRepository.loadRemoteCityWeatherByName(cityName))
            .thenReturn(expectedResult)

        val params = CityWeatherParams(cityName)

        val result = loadRemoteCityWeatherUseCase.execute(params)

        assert(result == expectedResult)
    }
}