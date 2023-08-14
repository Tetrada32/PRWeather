package com.gahov.prweather.data.remote.protocol

import com.gahov.prweather.data.remote.entities.weather.WeatherDataResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * An interface representing a protocol for weather-related API endpoints.
 */
interface WeatherProtocol {

    /**
     * Retrieves weather data by city name from the API.
     *
     * @param cityName The name of the city for which to retrieve weather data.
     * @param accessToken The access token required for API authorization.
     * @return A [Response] containing the weather data API response.
     */

    @GET("weather")
    suspend fun getWeatherByCityName(
        @Query("q") cityName: String?,
        @Query("appid") accessToken: String
    ): Response<WeatherDataResponse>
}