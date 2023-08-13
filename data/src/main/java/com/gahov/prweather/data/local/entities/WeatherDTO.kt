package com.gahov.prweather.data.local.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "weatherData", indices = [Index(value = ["id"], unique = true)]
)
data class WeatherDTO(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = 0,
    var cityName: String? = "",
    var countryName: String? = "",
    var weatherDescription: String? = "",
    var temperatureKelvin: Double? = 0.0,
    var humidity: Int? = 0,
    var windSpeed: Double? = 0.0,
    var iconId: String? = "",
    var time: String? = ""
)