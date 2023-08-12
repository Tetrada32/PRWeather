package com.gahov.prweather.arch.di.module

import com.gahov.prweather.domain.repository.weather.WeatherRepository
import com.gahov.prweather.domain.usecase.weather.LoadCityWeatherUseCase
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
    internal fun provideCityWeatherUseCase(
        weatherRepository: WeatherRepository
    ) = LoadCityWeatherUseCase(
        repository = weatherRepository
    )
}