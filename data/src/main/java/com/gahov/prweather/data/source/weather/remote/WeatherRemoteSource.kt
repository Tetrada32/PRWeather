package com.gahov.prweather.data.source.weather.remote

import com.gahov.prweather.data.remote.entities.weather.WeatherDataResponse
import com.gahov.prweather.domain.entities.common.Either
import com.gahov.prweather.domain.entities.failure.Failure

interface WeatherRemoteSource {

    suspend fun loadCityWeatherByName(cityName: String): Either<Failure, WeatherDataResponse>

}