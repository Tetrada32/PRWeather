package com.gahov.prweather.feature.search

import com.gahov.prweather.arch.controller.BaseViewModel
import com.gahov.prweather.domain.component.logger.Logger
import com.gahov.prweather.domain.entities.common.Either
import com.gahov.prweather.domain.entities.failure.Failure
import com.gahov.prweather.domain.entities.weather.CityWeatherParams
import com.gahov.prweather.domain.entities.weather.WeatherEntity
import com.gahov.prweather.domain.usecase.weather.LoadRemoteCityWeatherUseCase
import com.gahov.prweather.feature.search.command.CitySearchCommand
import javax.inject.Inject

class CitySearchViewModel @Inject constructor(
    private val loadCityWeatherUseCase: LoadRemoteCityWeatherUseCase
) : BaseViewModel() {

    fun onNewCityName(cityName: String) {
        if ((cityName.chars()).count() >= MINIMUM_CITY_NAME_LENGTH) {
            searchCityByInputName(CityWeatherParams(cityName))
        }
    }

    private fun searchCityByInputName(param: CityWeatherParams) {
        launch {
            when (val result = loadCityWeatherUseCase.execute(param = param)) {
                is Either.Right -> onResultSuccess(result = result.success)
                is Either.Left -> onResultFailure(result.failure)
            }
        }
    }

    private fun onResultSuccess(result: WeatherEntity) {
        navigateDirection(
            CitySearchBottomDialogFragmentDirections.actionCitySearchToCityDetails(
                cityWeatherData = result,
                cityName = result.cityName
            )
        )
    }

    private fun onResultFailure(failureResult: Failure) {
        handleCommand(CitySearchCommand.OnNetworkError(failureResult))
        handleFailure(failureResult)
    }

    companion object {
        private const val MINIMUM_CITY_NAME_LENGTH = 3
    }
}