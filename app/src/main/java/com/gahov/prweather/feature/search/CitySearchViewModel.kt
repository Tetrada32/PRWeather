package com.gahov.prweather.feature.search

import com.gahov.prweather.arch.controller.BaseViewModel
import com.gahov.prweather.domain.component.logger.Level
import com.gahov.prweather.domain.component.logger.Logger
import javax.inject.Inject

class CitySearchViewModel @Inject constructor(
    private val logger: Logger
) : BaseViewModel() {

    fun saveNewCityName(cityName: String) {
        if ((cityName.chars()).count() >= MINIMUM_CITY_NAME_LENGTH) {
            logger.log(Level.Info, "Input text: $cityName")
        }
    }

    companion object {
        private const val MINIMUM_CITY_NAME_LENGTH = 3
    }
}