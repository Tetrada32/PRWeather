package com.gahov.prweather.feature.main

import com.gahov.prweather.arch.controller.BaseViewModel
import com.gahov.prweather.domain.component.logger.Logger
import com.gahov.prweather.domain.usecase.weather.LoadCityWeatherUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val logger: Logger,
    private val loadCityWeatherUseCase: LoadCityWeatherUseCase
) : BaseViewModel() {
}