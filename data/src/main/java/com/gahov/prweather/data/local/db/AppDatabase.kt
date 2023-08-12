package com.gahov.prweather.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gahov.prweather.data.local.db.AppDatabase.Companion.DB_VERSION
import com.gahov.prweather.data.local.entities.CityWeatherDTO
import com.gahov.prweather.data.local.storage.weather.WeatherDao

@Database(
    entities = [CityWeatherDTO::class],
    version = DB_VERSION
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao

    companion object {
        const val DB_VERSION = 1
        var DB_NAME = "plan_radar_weather.db"
    }
}