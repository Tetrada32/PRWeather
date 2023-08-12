package com.gahov.prweather.data.remote.protocol

import com.gahov.prweather.data.remote.entities.weather.WeatherDataResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherProtocol {

    @GET("weather")
    suspend fun getWeatherByCityName(
        @Query("q") cityName: String?,
        @Query("appid") accessToken: String
    ): Response<WeatherDataResponse>
}