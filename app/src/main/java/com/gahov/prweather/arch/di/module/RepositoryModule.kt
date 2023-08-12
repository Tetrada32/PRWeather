package com.gahov.prweather.arch.di.module

import com.gahov.prweather.data.mapper.weather.local.WeatherDomainToLocalMapper
import com.gahov.prweather.data.mapper.weather.remote.WeatherResponseToDomainMapper
import com.gahov.prweather.data.repository.weather.ImplWeatherRepository
import com.gahov.prweather.data.source.weather.local.WeatherLocalSource
import com.gahov.prweather.data.source.weather.remote.WeatherRemoteSource
import com.gahov.prweather.domain.repository.weather.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    internal fun provideWeatherRepository(
        remoteSource: WeatherRemoteSource,
        localSource: WeatherLocalSource,
        remoteMapper: WeatherResponseToDomainMapper,
        localMapper: WeatherDomainToLocalMapper
    ): WeatherRepository {
        return ImplWeatherRepository(
            remoteSource = remoteSource,
            localSource = localSource,
            weatherRemoteMapper = remoteMapper,
            weatherLocalMapper = localMapper
        )
    }
}