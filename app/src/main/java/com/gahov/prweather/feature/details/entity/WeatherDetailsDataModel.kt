package com.gahov.prweather.feature.details.entity

import androidx.databinding.ObservableBoolean
import com.gahov.prweather.arch.ui.view.model.IconProvider
import com.gahov.prweather.arch.ui.view.model.TextProvider


data class WeatherDetailsDataModel(
    val id: Int? = null,
    val locationName: TextProvider? = null,
    val weatherIcon: IconProvider? = null,
    val mainTemperature: TextProvider? = null,
    val weatherFields: List<WeatherDetailsFieldModel>? = null,
    val weatherDate: TextProvider? = null,
    val requestTime: TextProvider? = null,
    var isLoading: ObservableBoolean = ObservableBoolean(true)
)