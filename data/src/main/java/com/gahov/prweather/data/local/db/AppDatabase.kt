package com.gahov.prweather.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gahov.prweather.data.local.db.AppDatabase.Companion.DB_VERSION
import com.gahov.prweather.data.local.entities.WeatherDTO
import com.gahov.prweather.data.local.storage.weather.WeatherDao

/**
 * An abstract Room database class representing the application's database.
 *
 * @see Database
 */
@Database(
    entities = [WeatherDTO::class],
    version = DB_VERSION
)

abstract class AppDatabase : RoomDatabase() {

    /**
     * Provides access to the WeatherDao for database operations related to weather data.
     *
     * @return An instance of the WeatherDao interface.
     */
    abstract fun weatherDao(): WeatherDao

    /**
     * A companion object containing constants and configuration for the database.
     */
    companion object {

        /**
         * The version of the database.
         * Should be increased every time the developer changes DTO or DB config.
         */
        const val DB_VERSION = 1

        /**
         * The name of the database file.
         */
        var DB_NAME = "plan_radar_weather.db"
    }
}