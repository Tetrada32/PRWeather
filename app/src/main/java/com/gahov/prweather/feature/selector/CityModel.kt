package com.gahov.prweather.feature.selector

import com.gahov.prweather.R
import com.gahov.prweather.arch.ui.view.model.IconProvider
import com.gahov.prweather.arch.ui.view.model.TextProvider
import java.io.Serializable

sealed class CityModel(
    private val locationName: TextProvider
) : Serializable {

    data class CityItem(
        val locationName: TextProvider,
        val cityIcon: IconProvider = IconProvider.ResIcon(R.drawable.ic_city),
        val historyIcon: IconProvider = IconProvider.ResIcon(R.drawable.ic_info)
    ) : CityModel(locationName = locationName), Serializable

    fun areItemsSame(model: CityModel): Boolean {
        return model.locationName == locationName
    }
}