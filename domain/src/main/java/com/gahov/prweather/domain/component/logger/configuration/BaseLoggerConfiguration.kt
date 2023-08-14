package com.gahov.prweather.domain.component.logger.configuration

/**
 * An abstract base class for configuring logger settings.
 */
abstract class BaseLoggerConfiguration : LoggerConfiguration {

    /**
     * Retrieves the simple class name from the provided object.
     *
     * @param any The object from which the simple class name is to be retrieved.
     * @return The simple class name of the object.
     */
    protected open fun getClassName(any: Any): String {
        if (any is String) {
            return any
        }
        var className = any.javaClass.name
        var firstPosition = className.lastIndexOf(".") + 1
        if (firstPosition < 0) {
            firstPosition = 0
        }
        className = className.substring(firstPosition)
        firstPosition = className.lastIndexOf("$")
        if (firstPosition > 0) {
            className = className.substring(0, firstPosition)
        }
        return className
    }
}