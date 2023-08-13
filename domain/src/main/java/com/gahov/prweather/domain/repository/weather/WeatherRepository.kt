package com.gahov.prweather.domain.repository.weather


import com.gahov.prweather.domain.entities.common.Either
import com.gahov.prweather.domain.entities.failure.Failure
import com.gahov.prweather.domain.entities.weather.WeatherEntity

interface WeatherRepository {

    suspend fun loadRemoteCityWeatherByName(cityName: String): Either<Failure, WeatherEntity>

    suspend fun saveCityWeatherData(weather: WeatherEntity)

    suspend fun getCitiesWeatherList(cityName: String = ""): Either<Failure, List<WeatherEntity>>

    suspend fun deleteLocalCity(cityName: String): Either<Failure, List<WeatherEntity>>

}