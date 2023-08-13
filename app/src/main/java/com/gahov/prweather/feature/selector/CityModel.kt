package com.gahov.prweather.feature.selector

import com.gahov.prweather.R
import com.gahov.prweather.arch.ui.view.model.IconProvider
import com.gahov.prweather.arch.ui.view.model.TextProvider
import java.io.Serializable


data class CityModel(
    val locationName: TextProvider,
    val cityName: String,
    val cityIcon: IconProvider = IconProvider.ResIcon(R.drawable.ic_city),
    val historyIcon: IconProvider = IconProvider.ResIcon(R.drawable.ic_info)
) : Serializable {

    fun areItemsSame(model: CityModel): Boolean {
        return model.locationName == locationName
    }
}