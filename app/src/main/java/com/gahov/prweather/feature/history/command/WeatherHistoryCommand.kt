package com.gahov.prweather.feature.history.command

import com.gahov.prweather.arch.router.command.Command
import com.gahov.prweather.domain.entities.failure.Failure
import com.gahov.prweather.feature.details.entity.WeatherDetailsDataModel


sealed class WeatherHistoryCommand : Command.FeatureCommand() {

    data class DisplayContent(var content: List<WeatherDetailsDataModel>) : WeatherHistoryCommand()

    data class OnError(var failure: Failure) : WeatherHistoryCommand()

}