package com.gahov.prweather.feature.selector.factory

import com.gahov.prweather.arch.ui.view.model.TextProvider
import com.gahov.prweather.domain.entities.weather.WeatherEntity
import com.gahov.prweather.feature.selector.CityModel

/**
 * A class responsible for building a list of CityModel instances from a list of WeatherEntity instances.
 */
class WeatherListToCityModelBuilder : CityEntityBuilder {

    /**
     * Builds a list of CityModel instances from the provided list of WeatherEntity instances.
     *
     * @param entityItems The list of WeatherEntity instances to be converted to CityModel instances.
     * @return The list of CityModel instances representing the data from the WeatherEntity instances.
     */
    override fun buildCityModel(entityItems: List<WeatherEntity>): List<CityModel> {
        return entityItems.map {
            CityModel(
                locationName = TextProvider.Text("${it.cityName}, ${it.countryName}"),
                cityName = it.cityName.toString()
            )
        }.distinctBy { it.cityName }
    }
}