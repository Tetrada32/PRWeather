package com.gahov.prweather.domain.entities.weather

data class WeatherEntity(
    val id: Int? = null,
    val cityName: String? = null,
    val countryName: String? = null,
    val weatherDescription: String? = null,
    val temperatureKelvin: Double? = null,
    val humidity: Int? = null,
    val windSpeed: Double? = null,
    val iconId: String? = null,
    val time: String? = null
)