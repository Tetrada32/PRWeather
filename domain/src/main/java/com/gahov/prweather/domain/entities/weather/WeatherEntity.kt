package com.gahov.prweather.domain.entities.weather

import android.os.Parcelable

/**
 * A data class representing weather information for a specific city.
 * The main data class of the entire application.
 *
 * @property id The unique identifier of the weather entry.
 * @property cityName The name of the city for which the weather information is recorded.
 * @property countryName The name of the country associated with the city.
 * @property weatherDescription A description of the weather conditions.
 * @property temperatureKelvin The temperature in Kelvin units.
 * @property humidity The humidity level (percent).
 * @property windSpeed The wind speed (km/h).
 * @property iconId The identifier for the weather icon.
 * @property time The time at which the weather information was recorded (18-08-2000 - 11:23).
 */

@kotlinx.parcelize.Parcelize
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
) : Parcelable