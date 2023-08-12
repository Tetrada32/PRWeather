package com.gahov.prweather.feature.selector.command

import com.gahov.prweather.arch.router.command.Command


sealed class CitySelectorCommand : Command.FeatureCommand() {

    data class DisplayContent(val string: String) : CitySelectorCommand()
}