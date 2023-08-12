package com.gahov.prweather.domain.entities.weather

import com.gahov.prweather.domain.common.usecase.UseCase


data class CityWeatherParams(
    val cityName: String
) : UseCase.Params()