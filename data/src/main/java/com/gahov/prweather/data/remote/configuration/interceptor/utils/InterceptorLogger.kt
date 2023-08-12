package com.gahov.prweather.data.remote.configuration.interceptor.utils

import com.gahov.prweather.domain.component.logger.Level
import com.gahov.prweather.domain.component.logger.Logger
import okhttp3.logging.HttpLoggingInterceptor

class InterceptorLogger(private val logger: Logger) : HttpLoggingInterceptor.Logger {

    private val loggerConfiguration = logger.getConfiguration().copy(className = "Network")

    override fun log(message: String) {
        logger.log(
            level = Level.Info,
            message = message,
            configuration = loggerConfiguration
        )
    }
}
