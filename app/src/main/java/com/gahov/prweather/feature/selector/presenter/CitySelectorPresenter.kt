package com.gahov.prweather.feature.selector.presenter

interface CitySelectorPresenter {

    fun onAddCityClick()

    fun onCityItemClick(cityName: String)

    fun onCityHistoryButtonClick(cityName: String)
}