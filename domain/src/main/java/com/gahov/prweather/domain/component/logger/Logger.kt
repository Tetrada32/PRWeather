package com.gahov.prweather.domain.component.logger

import com.gahov.prweather.domain.component.logger.configuration.LoggerConfiguration

/**
 * An interface representing a logger for creating logs with various configurations.
 */
interface Logger {
    /**
     * Retrieves the current configuration of the logger.
     *
     * @return The [LoggerConfiguration] object representing the current logger configuration.
     */
    fun getConfiguration(): LoggerConfiguration

    /**
     * Sets the configuration of the logger.
     *
     * @param configuration The [LoggerConfiguration] object to be set as the logger configuration.
     */
    fun setConfiguration(configuration: LoggerConfiguration)

    /**
     * Creates a log message with the specified level, message, and optional throwable.
     *
     * @param level The [Level] representing the level-type of the log.
     * @param message The log message to be recorded.
     * @param throwable An optional [Throwable] to be associated with the log message.
     * @param configuration The [LoggerConfiguration] object representing the logger's configuration.
     */
    fun log(
        level: Level = Level.Debug,
        message: String? = null,
        throwable: Throwable? = null,
        configuration: LoggerConfiguration = getConfiguration()
    )
}