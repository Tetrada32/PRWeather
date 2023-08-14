package com.gahov.prweather.feature.selector.factory

import com.gahov.prweather.domain.entities.weather.WeatherEntity
import com.gahov.prweather.feature.selector.CityModel

/**
 * An interface that defines the contract for building a list of CityModel instances from a
 * list of WeatherEntity instances.
 */
interface CityEntityBuilder {

    /**
     * Builds a list of CityModel instances from the provided list of WeatherEntity instances.
     *
     * @param entityItems The list of WeatherEntity instances to be converted to CityModel instances.
     * @return The list of CityModel instances representing the data from the WeatherEntity instances.
     */
    fun buildCityModel(entityItems: List<WeatherEntity>): List<CityModel>
}