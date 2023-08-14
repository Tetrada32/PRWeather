package com.gahov.prweather.domain.usecase

import com.gahov.prweather.domain.entities.common.Either
import com.gahov.prweather.domain.entities.weather.CityWeatherParams
import com.gahov.prweather.domain.entities.weather.WeatherEntity
import com.gahov.prweather.domain.repository.weather.WeatherRepository
import com.gahov.prweather.domain.usecase.weather.LocalCityWeatherListUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations


@OptIn(ExperimentalCoroutinesApi::class)
class LocalCityWeatherListUseCaseTest {

    @Mock
    private lateinit var mockRepository: WeatherRepository

    private lateinit var localCityWeatherListUseCase: LocalCityWeatherListUseCase

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        localCityWeatherListUseCase = LocalCityWeatherListUseCase(mockRepository)
    }

    @Test
    fun `execute should return the result from repository`() = runTest {
        val cityName = "Vienna"
        val weatherEntities = listOf(WeatherEntity(cityName = cityName))
        val expectedResult = Either.Right(weatherEntities)

        Mockito.`when`(mockRepository.getCitiesWeatherList(cityName))
            .thenReturn(expectedResult)

        val params = CityWeatherParams(cityName)

        val result = localCityWeatherListUseCase.execute(params)

        assert(result == expectedResult)
    }
}