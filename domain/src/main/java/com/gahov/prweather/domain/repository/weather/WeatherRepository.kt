package com.gahov.prweather.domain.repository.weather


import com.gahov.prweather.domain.entities.common.Either
import com.gahov.prweather.domain.entities.failure.Failure
import com.gahov.prweather.domain.entities.weather.WeatherEntity

interface WeatherRepository {

    suspend fun loadCityWeatherByName(cityName: String): Either<Failure, WeatherEntity>

    suspend fun saveCityWeatherData(weather: WeatherEntity)

}