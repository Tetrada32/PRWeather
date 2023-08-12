package com.gahov.prweather.feature.selector

import com.gahov.prweather.arch.controller.BaseViewModel
import com.gahov.prweather.arch.ui.view.model.TextProvider
import com.gahov.prweather.domain.component.logger.Logger
import com.gahov.prweather.domain.entities.common.Either
import com.gahov.prweather.domain.entities.failure.Failure
import com.gahov.prweather.domain.entities.weather.CityWeatherParams
import com.gahov.prweather.domain.entities.weather.WeatherEntity
import com.gahov.prweather.domain.usecase.weather.LoadCityWeatherUseCase
import com.gahov.prweather.feature.selector.command.CitySelectorCommand
import com.gahov.prweather.feature.selector.presenter.CitySelectorPresenter
import javax.inject.Inject

class CitySelectorViewModel @Inject constructor(
    private val logger: Logger,
    private val loadCityWeatherUseCase: LoadCityWeatherUseCase
) : BaseViewModel(), CitySelectorPresenter {

    init {
        mockCityList()
    }

    companion object {
        const val HARDCODED_CITY_NAME = "Vienna"
    }

    private fun getHardcodedParam(): CityWeatherParams {
        return CityWeatherParams(HARDCODED_CITY_NAME)
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

    fun loadWeatherContent() {
        launch {
            when (val result = loadCityWeatherUseCase.execute(param = getHardcodedParam())) {
                is Either.Right -> onResultSuccess(result = result.success)
                is Either.Left -> onResultFailure(result.failure)
            }
        }
    }

    private fun onResultSuccess(result: WeatherEntity) {
        logger.log(message = "Success: \n $result")
    }

    private fun onResultFailure(failureResult: Failure) {
        logger.log(message = "Failure: \n $failureResult")
    }

    override fun onAddCityClick() {
    }

    override fun onCityItemClick() {
        navigateDirection(CitySelectorFragmentDirections.actionCitySelectorToCityDetails())
    }

    override fun onCityHistoryButtonClick() {
        navigateDirection(CitySelectorFragmentDirections.actionCitySelectorToCityHistory())
    }
}