package com.gahov.prweather.domain.entities.weather

import com.gahov.prweather.domain.common.usecase.UseCase

/**
 * Data class representing parameters for retrieving weather information for a specific city.
 *
 * @property cityName The name of the city for which weather information is to be retrieved.
 */
data class CityWeatherParams(
    val cityName: String
) : UseCase.Params()