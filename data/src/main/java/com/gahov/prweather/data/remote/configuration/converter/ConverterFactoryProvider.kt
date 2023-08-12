package com.gahov.prweather.data.remote.configuration.converter

import retrofit2.Converter

interface ConverterFactoryProvider {
    val converterFactory: Converter.Factory
}