package com.gahov.prweather.arch.di.module

import com.gahov.prweather.domain.repository.weather.WeatherRepository
import com.gahov.prweather.domain.usecase.weather.LoadRemoteCityWeatherUseCase
import com.gahov.prweather.domain.usecase.weather.LocalCityWeatherListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    internal fun provideRemoteCityWeatherUseCase(
        weatherRepository: WeatherRepository
    ) = LoadRemoteCityWeatherUseCase(
        repository = weatherRepository
    )

    @Provides
    @Singleton
    internal fun provideLocalCityWeatherListUseCase(
        weatherRepository: WeatherRepository
    ) = LocalCityWeatherListUseCase(
        repository = weatherRepository
    )
}