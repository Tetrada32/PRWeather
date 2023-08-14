package com.gahov.prweather.arch.router.command

/**
 * A sealed class representing different types of commands for controlling app behavior and navigation.
 */

sealed class Command {
    object Back : Command()
    object Root : Command()
    object Close : Command()

    abstract class Route : Command()
    abstract class FeatureCommand : Command()
}