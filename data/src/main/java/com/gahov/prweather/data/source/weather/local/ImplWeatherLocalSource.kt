package com.gahov.prweather.data.source.weather.local


import com.gahov.prweather.data.local.entities.WeatherDTO
import com.gahov.prweather.data.local.storage.weather.WeatherDao

class ImplWeatherLocalSource(
    private val weatherDao: WeatherDao
) : WeatherLocalSource {

    override suspend fun saveWeather(weatherData: WeatherDTO) {
        weatherDao.insertItems(listOf(weatherData))
    }

    override suspend fun getAllWeatherData(cityName: String): List<WeatherDTO> {
        return if (cityName.isNotBlank()) {
            weatherDao.getWeatherDataByCityName(cityName)
        } else {
            return weatherDao.select()
        }
    }

    override suspend fun deleteAllWeatherData(cityName: String) {
        weatherDao.deleteWeatherDataByCityName(cityName)
    }
}