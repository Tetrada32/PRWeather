package com.gahov.prweather.data.source.weather.local


import com.gahov.prweather.data.local.entities.CityWeatherDTO
import com.gahov.prweather.data.local.storage.weather.WeatherDao

class ImplWeatherLocalSource(
    private val weatherDao: WeatherDao
) : WeatherLocalSource {

    override suspend fun saveWeather(weatherData: CityWeatherDTO) {
        weatherDao.insertItems(listOf(weatherData))
    }
}