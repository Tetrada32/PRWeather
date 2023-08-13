package com.gahov.prweather.data.source.weather.local

import com.gahov.prweather.data.local.entities.WeatherDTO

interface WeatherLocalSource {

    suspend fun saveWeather(weatherData: WeatherDTO)

    suspend fun getAllWeatherData(cityName: String): List<WeatherDTO>

    suspend fun deleteAllWeatherData(cityName: String)
}