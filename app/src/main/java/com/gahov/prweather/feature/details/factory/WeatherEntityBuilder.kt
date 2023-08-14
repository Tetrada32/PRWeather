package com.gahov.prweather.feature.details.factory

import com.gahov.prweather.domain.entities.weather.WeatherEntity
import com.gahov.prweather.feature.details.entity.WeatherDetailsDataModel

/**
 * An interface that defines the contract for building a WeatherDetailsDataModel from a WeatherEntity.
 * It is required for setting-up the "View" implementation of the "WeatherDetails" feature.
 */
interface WeatherEntityBuilder {

    fun buildWeatherModel(entityItem: WeatherEntity): WeatherDetailsDataModel
}