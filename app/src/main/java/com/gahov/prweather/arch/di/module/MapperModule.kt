package com.gahov.prweather.arch.di.module

import com.gahov.prweather.data.mapper.weather.remote.WeatherResponseToDomainMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MapperModule {

    @Provides
    @Singleton
    internal fun provideWeatherRemoteMapper(): WeatherResponseToDomainMapper =
        WeatherResponseToDomainMapper()
}