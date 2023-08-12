package com.gahov.prweather.feature.history

import com.gahov.prweather.R
import com.gahov.prweather.arch.controller.BaseViewModel
import com.gahov.prweather.arch.router.command.Command
import com.gahov.prweather.arch.ui.view.model.IconProvider
import com.gahov.prweather.arch.ui.view.model.TextProvider
import com.gahov.prweather.feature.details.entity.WeatherDetailsDataModel
import com.gahov.prweather.feature.history.command.WeatherHistoryCommand
import com.gahov.prweather.feature.history.presenter.WeatherHistoryPresenter
import javax.inject.Inject

class WeatherHistoryViewModel @Inject constructor(
) : BaseViewModel(), WeatherHistoryPresenter {

    fun mockContent() {
        handleCommand(
            WeatherHistoryCommand.DisplayContent(
                listOf(
                    WeatherDetailsDataModel(
                        locationName = TextProvider.Text("Linz, At"),
                        weatherIcon = IconProvider.ResIcon(R.drawable.ic_info),
                        mainTemperature = TextProvider.Text("20 degrees"),
                        weatherFields = null,
                        weatherDate = TextProvider.Text("12.08.2023 - 23:47")
                    ),
                    WeatherDetailsDataModel(
                        locationName = TextProvider.Text("Vienna, At"),
                        weatherIcon = IconProvider.ResIcon(R.drawable.ic_city),
                        mainTemperature = TextProvider.Text("-4 degrees"),
                        weatherFields = null,
                        weatherDate = TextProvider.Text("08.12.2023 - 09:32")
                    )
                )
            )
        )
    }

    override fun onBackButtonClick() {
        handleCommand(Command.Root)
    }

    override fun onItemClick() {
        navigateDirection(WeatherHistoryFragmentDirections.actionCityHistoryToCityDetails())
    }
}