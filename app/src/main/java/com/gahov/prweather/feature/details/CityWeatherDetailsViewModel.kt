package com.gahov.prweather.feature.details

import com.gahov.prweather.arch.controller.BaseViewModel
import com.gahov.prweather.arch.router.command.Command
import com.gahov.prweather.domain.entities.common.Either
import com.gahov.prweather.domain.entities.failure.Failure
import com.gahov.prweather.domain.entities.weather.CityWeatherParams
import com.gahov.prweather.domain.entities.weather.WeatherEntity
import com.gahov.prweather.domain.usecase.weather.LoadRemoteCityWeatherUseCase
import com.gahov.prweather.feature.details.command.CityWeatherDetailsCommand
import com.gahov.prweather.feature.details.factory.WeatherEntityToModelBuilder
import com.gahov.prweather.feature.details.presenter.CityWeatherDetailsPresenter
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class CityWeatherDetailsViewModel @Inject constructor(
    private val modelBuilder: WeatherEntityToModelBuilder,
    private val loadCityWeatherUseCase: LoadRemoteCityWeatherUseCase
) : BaseViewModel(), CityWeatherDetailsPresenter {

    fun loadContent(args: CityWeatherDetailsFragmentArgs) {
        val cityData = args.cityWeatherData
        val cityName = args.cityName

        if (cityData == null) {
            loadWeatherContentByCityName(cityName ?: return)
        } else {
            onResultSuccess(cityData)
        }
    }

    private fun loadWeatherContentByCityName(cityName: String) {
        launch(Dispatchers.IO) {
            when (val result =
                loadCityWeatherUseCase.execute(param = CityWeatherParams(cityName))) {
                is Either.Right -> onResultSuccess(result = result.success)
                is Either.Left -> onResultFailure(result.failure)
            }
        }
    }

    private fun onResultSuccess(result: WeatherEntity) {
        handleCommand(
            CityWeatherDetailsCommand.DisplayContent(modelBuilder.buildWeatherModel(result))
        )
    }

    private fun onResultFailure(failureResult: Failure) {
        handleCommand(CityWeatherDetailsCommand.OnNetworkError(failureResult))
    }

    override fun onBackPressed() {
        handleCommand(Command.Root)
    }
}