package com.gahov.prweather.feature.history

import com.gahov.prweather.R
import com.gahov.prweather.arch.ui.fragment.BaseFragment
import com.gahov.prweather.databinding.FragmentCityHistoryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherHistoryFragment :
    BaseFragment<FragmentCityHistoryBinding, WeatherHistoryViewModel>(
        contentLayoutID = R.layout.fragment_city_history,
        viewModelClass = WeatherHistoryViewModel::class.java
    ) {
}