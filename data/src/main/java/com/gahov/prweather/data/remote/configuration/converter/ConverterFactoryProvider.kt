package com.gahov.prweather.data.remote.configuration.converter

import retrofit2.Converter

/**
 * An interface for providing a converter factory for handling data serialization and deserialization.
 */
interface ConverterFactoryProvider {
    val converterFactory: Converter.Factory
}