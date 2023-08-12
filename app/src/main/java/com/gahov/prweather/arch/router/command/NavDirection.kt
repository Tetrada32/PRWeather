package com.gahov.prweather.arch.router.command

import androidx.navigation.NavDirections
import androidx.navigation.NavOptions

sealed class NavDirection : Command.Route() {
    data class Direction(val directions: NavDirections, val options: NavOptions? = null) :
        NavDirection()

    data class BackTo(val destinationId: Int, val inclusive: Boolean = false) : NavDirection()
}