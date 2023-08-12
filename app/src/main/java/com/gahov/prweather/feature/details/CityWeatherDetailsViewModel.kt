package com.gahov.prweather.feature.details

import com.gahov.prweather.arch.controller.BaseViewModel
import com.gahov.prweather.domain.component.logger.Logger
import javax.inject.Inject

class CityWeatherDetailsViewModel @Inject constructor(
    private val logger: Logger,
) : BaseViewModel() {
}