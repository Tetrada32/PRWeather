package com.gahov.prweather.data.source.weather.local


import com.gahov.prweather.data.local.entities.WeatherDTO
import com.gahov.prweather.data.local.storage.weather.WeatherDao

class ImplWeatherLocalSource(
    private val weatherDao: WeatherDao
) : WeatherLocalSource {

    override suspend fun saveWeather(weatherData: WeatherDTO) {
        weatherDao.insertItems(listOf(weatherData))
    }

    override suspend fun getAllWeatherData(): List<WeatherDTO> {
        return weatherDao.select()
    }
}