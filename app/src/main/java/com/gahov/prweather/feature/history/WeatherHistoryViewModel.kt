package com.gahov.prweather.feature.history

import com.gahov.prweather.arch.controller.BaseViewModel
import com.gahov.prweather.arch.router.command.Command
import com.gahov.prweather.domain.entities.common.Either
import com.gahov.prweather.domain.entities.weather.CityWeatherParams
import com.gahov.prweather.domain.entities.weather.WeatherEntity
import com.gahov.prweather.domain.usecase.weather.LocalCityWeatherListUseCase
import com.gahov.prweather.feature.details.entity.WeatherDetailsDataModel
import com.gahov.prweather.feature.details.factory.WeatherEntityToModelBuilder
import com.gahov.prweather.feature.history.command.WeatherHistoryCommand
import com.gahov.prweather.feature.history.presenter.WeatherHistoryPresenter
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class WeatherHistoryViewModel @Inject constructor(
    private val loadLocalWeatherListUseCase: LocalCityWeatherListUseCase,
    private val modelBuilder: WeatherEntityToModelBuilder,
) : BaseViewModel(), WeatherHistoryPresenter {

    private val currentCityWeatherLocalList = emptyList<WeatherEntity>().toMutableList()

    fun loadLocalWeatherHistory(cityName: String) {
        launch(Dispatchers.IO) {
            when (val result = loadLocalWeatherListUseCase.execute(CityWeatherParams(cityName))) {
                is Either.Right -> onResultSuccess(result.success)
                is Either.Left -> error(result.failure)
            }
        }
    }

    private fun onResultSuccess(result: List<WeatherEntity>) {
        temporallySaveWeatherData(result)

        val mappedResult = result.map { modelBuilder.buildWeatherModel(it) }
        handleCommand(WeatherHistoryCommand.DisplayContent(mappedResult))
    }

    private fun temporallySaveWeatherData(result: List<WeatherEntity>) {
        currentCityWeatherLocalList.addAll(result)
    }

    private fun findWeatherDetailsById(itemId: Int?): WeatherEntity? {
        return currentCityWeatherLocalList.find { it.id == itemId }
    }

    override fun onBackButtonClick() {
        handleCommand(Command.Root)
    }

    override fun onItemClick(item: WeatherDetailsDataModel) {
        navigateDirection(
            WeatherHistoryFragmentDirections.actionCityHistoryToCityDetails(
                findWeatherDetailsById(item.id)
            )
        )
    }
}