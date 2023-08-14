package com.gahov.prweather.data.remote.configuration.converter

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Converter

/**
 * A class providing a converter factory for handling JSON serialization and deserialization
 * using Kotlin serialization.
 */
class KotlinConverterFactory : ConverterFactoryProvider {

    private val contentType: MediaType by lazy { "application/json".toMediaType() }
    private val jsonConfiguration: Json by lazy { Json { ignoreUnknownKeys = true } }

    @OptIn(ExperimentalSerializationApi::class)
    override val converterFactory: Converter.Factory by lazy {
        jsonConfiguration.asConverterFactory(
            contentType
        )
    }
}