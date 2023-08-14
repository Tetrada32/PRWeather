package com.gahov.prweather.domain.component.logger

/**
 * A sealed class representing different levels of logging.
 * These levels are used to create logs with varying levels of severity.
 */
sealed class Level {
    object Debug : Level()
    object Info : Level()
    object Warning : Level()
    object Error : Level()
}