package com.gahov.prweather.feature.history.presenter

import com.gahov.prweather.feature.details.entity.WeatherDetailsDataModel

interface WeatherHistoryPresenter {

    fun onBackButtonClick()

    fun onItemClick(item: WeatherDetailsDataModel)
}