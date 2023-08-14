package com.gahov.prweather.domain.repository.weather


import com.gahov.prweather.domain.entities.common.Either
import com.gahov.prweather.domain.entities.failure.Failure
import com.gahov.prweather.domain.entities.weather.WeatherEntity

/**
 * A repository interface for weather-related data async operations.
 */

interface WeatherRepository {

    /**
     * To load remote weather information for a specified city by name.
     *
     * @param cityName The name of the city for which to retrieve weather information.
     * @return An [Either] instance containing either a [Failure] if the operation fails,
     * or a [WeatherEntity] representing the remote weather information for the city.
     */
    suspend fun loadRemoteCityWeatherByName(cityName: String): Either<Failure, WeatherEntity>

    /**
     * To saves weather data for a city to a local storage.
     *
     * @param weather The [WeatherEntity] representing the weather information to be mapped and saved.
     */
    suspend fun saveCityWeatherData(weather: WeatherEntity)

    /**
     * To retrieve a list of weather information for local cities.
     *
     *
     * @param cityName The name of the city for which to retrieve weather information.
     * If not provided, retrieves information for all cities.
     *
     * @return An [Either] instance containing either a [Failure] if the operation fails,
     * or a [List] of [WeatherEntity] representing the weather information for the list of cities.
     */
    suspend fun getCitiesWeatherList(cityName: String = ""): Either<Failure, List<WeatherEntity>>

    /**
     * Deletes all weather information of specific city.
     *
     * @param cityName The name of the city for which to delete weather information.
     * @return An [Either] instance containing either a [Failure] if the operation fails, or a [List] of [WeatherEntity] representing the updated list of weather information after deletion.
     */
    suspend fun deleteLocalCity(cityName: String): Either<Failure, List<WeatherEntity>>

}