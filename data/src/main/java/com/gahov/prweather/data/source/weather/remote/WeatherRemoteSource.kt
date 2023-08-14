package com.gahov.prweather.data.source.weather.remote

import com.gahov.prweather.data.remote.entities.weather.WeatherDataResponse
import com.gahov.prweather.domain.entities.common.Either
import com.gahov.prweather.domain.entities.failure.Failure

/**
 * An interface representing a remote data source for loading weather-related information.
 */
interface WeatherRemoteSource {

    /**
     * Loads weather data for a specific city from a remote data source.
     *
     * @param cityName The name of the city for which to load weather data.
     * @return An [Either] result containing either a successful [WeatherDataResponse] or a [Failure].
     */
    suspend fun loadCityWeatherByName(cityName: String): Either<Failure, WeatherDataResponse>

}