package com.gahov.prweather.feature.details.factory

import com.gahov.prweather.domain.entities.weather.WeatherEntity
import com.gahov.prweather.feature.details.entity.WeatherDetailsDataModel

interface WeatherEntityBuilder {

    fun buildWeatherModel(entityItem: WeatherEntity): WeatherDetailsDataModel
}