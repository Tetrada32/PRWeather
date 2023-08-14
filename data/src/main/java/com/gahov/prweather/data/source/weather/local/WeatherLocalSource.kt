package com.gahov.prweather.data.source.weather.local

import com.gahov.prweather.data.local.entities.WeatherDTO

/**
 * An interface representing a local data source for weather-related information.
 */
interface WeatherLocalSource {

    /**
     * Saves weather data to the local data source.
     *
     * @param weatherData The weather data to be saved.
     */
    suspend fun saveWeather(weatherData: WeatherDTO)

    /**
     * Retrieves all weather data for a specific city from the local data source.
     *
     * @param cityName The name of the city for which to retrieve weather data.
     * @return A list of [WeatherDTO] containing weather information for the city.
     */
    suspend fun getAllWeatherData(cityName: String): List<WeatherDTO>

    /**
     * Deletes all weather data for a specific city from the local data source.
     *
     * @param cityName The name of the city for which to delete weather data.
     */
    suspend fun deleteAllWeatherData(cityName: String)
}