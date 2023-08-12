package com.gahov.prweather.feature.history

import com.gahov.prweather.arch.controller.BaseViewModel
import com.gahov.prweather.domain.component.logger.Logger
import javax.inject.Inject

class WeatherHistoryViewModel @Inject constructor(
    private val logger: Logger,
) : BaseViewModel() {
}