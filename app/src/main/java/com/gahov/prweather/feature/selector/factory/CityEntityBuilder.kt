package com.gahov.prweather.feature.selector.factory

import com.gahov.prweather.domain.entities.weather.WeatherEntity
import com.gahov.prweather.feature.selector.CityModel

interface CityEntityBuilder {

    fun buildCityModel(entityItems: List<WeatherEntity>): List<CityModel>
}