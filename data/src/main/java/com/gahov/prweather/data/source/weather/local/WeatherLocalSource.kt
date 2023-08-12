package com.gahov.prweather.data.source.weather.local

import com.gahov.prweather.data.local.entities.CityWeatherDTO

interface WeatherLocalSource {

    suspend fun saveWeather(weatherData: CityWeatherDTO)

}