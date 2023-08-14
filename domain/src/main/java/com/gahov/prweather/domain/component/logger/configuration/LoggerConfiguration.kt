package com.gahov.prweather.domain.component.logger.configuration

/**
 * An interface for configuring logger settings.
 */
interface LoggerConfiguration {
    /**
     * The class name associated with the logger configuration.
     */
    val className: String

    /**
     * Indicates whether logging is enabled for the associated class.
     */
    val isEnabled: Boolean

    /**
     * Creates a copy of the logger configuration with optional changes.
     *
     * @param className The class name to be associated with the new logger configuration.
     * @param isEnabled The flag indicating whether logging is enabled in the new configuration.
     * @return A new [LoggerConfiguration] instance with the specified changes.
     */
    fun copy(
        className: Any = this.className,
        isEnabled: Boolean = this.isEnabled
    ): LoggerConfiguration
}