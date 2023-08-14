package com.gahov.prweather.arch.router.command

import androidx.navigation.NavDirections
import androidx.navigation.NavOptions

/**
 * A sealed class representing different navigation directions to be used in navigation commands.
 */

sealed class NavDirection : Command.Route() {

    /**
     * Represents a navigation direction to a specific destination using NavDirections.
     *
     * @param directions The NavDirections for navigating to the destination.
     * @param options Optional NavOptions for navigation.
     */
    data class Direction(val directions: NavDirections, val options: NavOptions? = null) :
        NavDirection()

    /**
     * Represents a navigation direction to pop back to a specific destination.
     *
     * @param destinationId The ID of the destination to pop back to.
     * @param inclusive Whether the destination fragment should also be popped.
     */
    data class BackTo(val destinationId: Int, val inclusive: Boolean = false) : NavDirection()
}