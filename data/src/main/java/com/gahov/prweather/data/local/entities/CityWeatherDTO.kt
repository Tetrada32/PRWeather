package com.gahov.prweather.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "cityWeather", indices = [Index(value = ["id"], unique = true)]
)
data class CityWeatherDTO(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "uid")
    var uid: Long = 0,
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