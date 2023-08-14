package com.gahov.prweather.arch.component.logger.configuration

import com.gahov.prweather.domain.component.logger.configuration.BaseLoggerConfiguration

/**
 * A default implementation of [LoggerConfiguration] with optional parameters for customization.
 *
 * @param className The name of the class associated with the logger. If not provided, the name of the current class will be used.
 * @param isEnabled Specifies whether logging is enabled for this configuration.
 */

class DefaultLoggerConfiguration(
    className: Any? = null, override val isEnabled: Boolean = true
) : BaseLoggerConfiguration() {

    override val className: String = getClassName(className ?: this)

    override fun copy(className: Any, isEnabled: Boolean) =
        DefaultLoggerConfiguration(this.className, isEnabled)

}