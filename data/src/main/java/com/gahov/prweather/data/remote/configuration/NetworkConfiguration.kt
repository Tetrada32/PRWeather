package com.gahov.prweather.data.remote.configuration

import com.gahov.prweather.data.remote.configuration.converter.ConverterFactoryProvider
import com.gahov.prweather.data.remote.configuration.converter.KotlinConverterFactory
import com.gahov.prweather.data.remote.url.UrlProvider

/**
 * A sealed class representing network configuration settings.
 */

sealed class NetworkConfiguration {
    abstract val serverUrlProvider: UrlProvider

    open val timeout: Long = 30L * 1000

    open val withLogs = true

    open val converterFactoryProvider: ConverterFactoryProvider = KotlinConverterFactory()

    class DefaultConfiguration(
        override val serverUrlProvider: UrlProvider,
    ) : NetworkConfiguration()
}