package com.gahov.prweather.feature.search.command

import com.gahov.prweather.arch.router.command.Command
import com.gahov.prweather.domain.entities.failure.Failure


sealed class CitySearchCommand : Command.FeatureCommand() {

    data class OnNetworkError(var failure: Failure) : CitySearchCommand()

}