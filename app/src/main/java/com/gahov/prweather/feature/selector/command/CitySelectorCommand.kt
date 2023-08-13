package com.gahov.prweather.feature.selector.command

import com.gahov.prweather.arch.router.command.Command
import com.gahov.prweather.feature.selector.CityModel


sealed class CitySelectorCommand : Command.FeatureCommand() {

    data class DisplayContent(var content: List<CityModel>) : CitySelectorCommand()

}