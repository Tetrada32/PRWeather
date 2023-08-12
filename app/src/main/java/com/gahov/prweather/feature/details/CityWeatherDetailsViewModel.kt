package com.gahov.prweather.feature.details

import com.gahov.prweather.arch.controller.BaseViewModel
import com.gahov.prweather.domain.component.logger.Logger
import com.gahov.prweather.domain.entities.common.Either
import com.gahov.prweather.domain.entities.failure.Failure
import com.gahov.prweather.domain.entities.weather.CityWeatherParams
import com.gahov.prweather.domain.entities.weather.WeatherEntity
import com.gahov.prweather.domain.usecase.weather.LoadCityWeatherUseCase
import com.gahov.prweather.feature.details.command.CityWeatherDetailsCommand
import com.gahov.prweather.feature.details.factory.WeatherEntityToModelBuilder
import javax.inject.Inject

class CityWeatherDetailsViewModel @Inject constructor(
    private val logger: Logger,
    private val modelBuilder: WeatherEntityToModelBuilder,
    private val loadCityWeatherUseCase: LoadCityWeatherUseCase
) : BaseViewModel() {

    companion object {
        const val HARDCODED_CITY_NAME = "Vienna"
    }

    private fun getHardcodedParam(): CityWeatherParams {
        return CityWeatherParams(HARDCODED_CITY_NAME)
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
        handleCommand(
            CityWeatherDetailsCommand.DisplayContent(
                content =
                modelBuilder.buildWeatherModel(result)
            )
        )
        logger.log(message = "Success: \n $result")
    }

    private fun onResultFailure(failureResult: Failure) {
        logger.log(message = "Failure: \n $failureResult")
    }
}