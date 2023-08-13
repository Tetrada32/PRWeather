package com.gahov.prweather.feature.details.command

import com.gahov.prweather.arch.router.command.Command
import com.gahov.prweather.domain.entities.failure.Failure
import com.gahov.prweather.feature.details.entity.WeatherDetailsDataModel


sealed class CityWeatherDetailsCommand : Command.FeatureCommand() {

    data class DisplayContent(var content: WeatherDetailsDataModel) : CityWeatherDetailsCommand()

    data class OnError(var failure: Failure) : CityWeatherDetailsCommand()
}