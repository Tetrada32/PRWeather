package com.gahov.prweather.feature.selector

import com.gahov.prweather.arch.controller.BaseViewModel
import com.gahov.prweather.arch.ui.view.model.TextProvider
import com.gahov.prweather.feature.selector.command.CitySelectorCommand
import com.gahov.prweather.feature.selector.presenter.CitySelectorPresenter
import javax.inject.Inject

class CitySelectorViewModel @Inject constructor() : BaseViewModel(), CitySelectorPresenter {

    init {
        mockCityList()
    }

    private fun mockCityList() {
        handleCommand(
            CitySelectorCommand.DisplayContent(
                content = listOf(
                    CityModel.CityItem(
                        locationName = TextProvider.Text("Vienna, AT")
                    ),
                    CityModel.CityItem(
                        locationName = TextProvider.Text("Kiev, UA")
                    )
                )
            )
        )
    }

    override fun onAddCityClick() {
        navigateDirection(CitySelectorFragmentDirections.actionCitySelectorToCitySearch())
    }

    override fun onCityItemClick() {
        navigateDirection(CitySelectorFragmentDirections.actionCitySelectorToCityDetails())
    }

    override fun onCityHistoryButtonClick() {
        navigateDirection(CitySelectorFragmentDirections.actionCitySelectorToCityHistory())
    }
}