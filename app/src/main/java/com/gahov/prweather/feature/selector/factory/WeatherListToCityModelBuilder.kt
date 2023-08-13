package com.gahov.prweather.feature.selector.factory

import com.gahov.prweather.arch.ui.view.model.TextProvider
import com.gahov.prweather.domain.entities.weather.WeatherEntity
import com.gahov.prweather.feature.selector.CityModel

class WeatherListToCityModelBuilder : CityEntityBuilder {

    override fun buildCityModel(entityItems: List<WeatherEntity>): List<CityModel> {
        return entityItems.map {
            CityModel(
                locationName = TextProvider.Text("${it.cityName}, ${it.countryName}"),
                cityName = it.cityName.toString()
            )
        }.distinctBy { it.cityName }
    }
}