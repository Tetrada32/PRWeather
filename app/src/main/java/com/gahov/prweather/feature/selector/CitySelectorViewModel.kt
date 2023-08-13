package com.gahov.prweather.feature.selector

import com.gahov.prweather.arch.controller.BaseViewModel
import com.gahov.prweather.domain.entities.common.Either
import com.gahov.prweather.domain.entities.weather.WeatherEntity
import com.gahov.prweather.domain.usecase.weather.LocalCityWeatherListUseCase
import com.gahov.prweather.feature.selector.command.CitySelectorCommand
import com.gahov.prweather.feature.selector.factory.CityEntityBuilder
import com.gahov.prweather.feature.selector.presenter.CitySelectorPresenter
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class CitySelectorViewModel @Inject constructor(
    private val cityEntityBuilder: CityEntityBuilder,
    private val loadLocalWeatherListUseCase: LocalCityWeatherListUseCase
) : BaseViewModel(), CitySelectorPresenter {

    init {
        loadAllCashedWeatherData()
    }

    private fun loadAllCashedWeatherData() {
        launch(Dispatchers.IO) {
            when (val result = loadLocalWeatherListUseCase.execute()) {
                is Either.Right -> processResult(result.success)
                is Either.Left -> error(result.failure)
            }
        }
    }

    private fun processResult(result: List<WeatherEntity>) {
        handleCommand(
            CitySelectorCommand.DisplayContent(cityEntityBuilder.buildCityModel(result))
        )
    }

    override fun onAddCityClick() {
        navigateDirection(CitySelectorFragmentDirections.actionCitySelectorToCitySearch())
    }

    override fun onCityItemClick(cityName: String) {
        navigateDirection(
            CitySelectorFragmentDirections.actionCitySelectorToCityDetails(
                cityWeatherData = null,
                cityName = null
            )
        )
    }

    override fun onCityHistoryButtonClick(cityName: String) {
        navigateDirection(CitySelectorFragmentDirections.actionCitySelectorToCityHistory())
    }
}