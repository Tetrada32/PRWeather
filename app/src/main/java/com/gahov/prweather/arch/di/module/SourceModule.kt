package com.gahov.prweather.arch.di.module

import com.gahov.prweather.data.local.storage.weather.WeatherDao
import com.gahov.prweather.data.remote.configuration.interceptor.utils.token.TokenProvider
import com.gahov.prweather.data.remote.protocol.WeatherProtocol
import com.gahov.prweather.data.source.weather.local.ImplWeatherLocalSource
import com.gahov.prweather.data.source.weather.local.WeatherLocalSource
import com.gahov.prweather.data.source.weather.remote.ImplWeatherRemoteSource
import com.gahov.prweather.data.source.weather.remote.WeatherRemoteSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SourceModule {

    @Provides
    @Singleton
    internal fun provideWeatherRemoteSource(
        protocol: WeatherProtocol,
        tokenProvider: TokenProvider
    ): WeatherRemoteSource {
        return ImplWeatherRemoteSource(
            protocol = protocol,
            tokenProvider = tokenProvider
        )
    }

    @Provides
    @Singleton
    internal fun provideWeatherLocalSource(
        weatherDao: WeatherDao,
    ): WeatherLocalSource {
        return ImplWeatherLocalSource(weatherDao)
    }
}