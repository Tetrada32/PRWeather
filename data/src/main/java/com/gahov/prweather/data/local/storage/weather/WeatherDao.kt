package com.gahov.prweather.data.local.storage.weather

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.gahov.prweather.data.local.entities.CityWeatherDTO

@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItems(cityWeatherList: List<CityWeatherDTO>)

    @Query("SELECT * FROM cityWeather")
    fun select() : List<CityWeatherDTO>

    @Query("DELETE FROM cityWeather")
    fun deleteAll()

}