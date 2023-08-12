package com.gahov.prweather.feature.details

import com.gahov.prweather.R
import com.gahov.prweather.arch.ui.fragment.BaseFragment
import com.gahov.prweather.databinding.FragmentCityWeatherDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CityWeatherDetailsFragment :
    BaseFragment<FragmentCityWeatherDetailsBinding, CityWeatherDetailsViewModel>(
        contentLayoutID = R.layout.fragment_city_weather_details,
        viewModelClass = CityWeatherDetailsViewModel::class.java
    ) {
}