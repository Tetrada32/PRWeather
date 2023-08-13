package com.gahov.prweather.data.local.storage.weather

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gahov.prweather.data.local.entities.WeatherDTO

@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItems(cityWeatherList: List<WeatherDTO>)

    @Query("SELECT * FROM weatherData")
    fun select() : List<WeatherDTO>

    @Query("SELECT * FROM weatherData WHERE cityName = :cityName")
    fun getWeatherDataByCityName(cityName: String): List<WeatherDTO>

    @Query("DELETE FROM weatherData")
    fun deleteAll()

}