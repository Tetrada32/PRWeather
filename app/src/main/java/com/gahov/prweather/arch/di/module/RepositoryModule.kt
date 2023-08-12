package com.gahov.prweather.arch.di.module

import com.gahov.prweather.data.mapper.weather.remote.WeatherResponseToDomainMapper
import com.gahov.prweather.data.repository.weather.ImplWeatherRepository
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
        newsRemoteSource: WeatherRemoteSource,
        articleRemoteMapper: WeatherResponseToDomainMapper
    ): WeatherRepository {
        return ImplWeatherRepository(
            remoteSource = newsRemoteSource,
            weatherRemoteMapper = articleRemoteMapper
        )
    }
}