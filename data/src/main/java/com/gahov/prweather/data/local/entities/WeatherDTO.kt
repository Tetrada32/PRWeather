package com.gahov.prweather.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "weatherData"
)
data class WeatherDTO(
    var id: Long? = 0,
    var cityName: String? = "",
    var countryName: String? = "",
    var weatherDescription: String? = "",
    var temperatureKelvin: Double? = 0.0,
    var humidity: Int? = 0,
    var windSpeed: Double? = 0.0,
    var iconId: String? = "",
    var time: String? = ""
) {
    @PrimaryKey(autoGenerate = true)
    var uid: Long = 0
}