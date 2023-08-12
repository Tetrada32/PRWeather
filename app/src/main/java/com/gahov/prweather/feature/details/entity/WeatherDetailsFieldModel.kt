package com.gahov.prweather.feature.details.entity

import com.gahov.prweather.arch.ui.view.model.TextProvider

data class WeatherDetailsFieldModel(
    val field: TextProvider? = null,
    val value: TextProvider? = null
)