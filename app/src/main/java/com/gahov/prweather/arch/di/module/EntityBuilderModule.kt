package com.gahov.prweather.arch.di.module

import android.content.Context
import com.gahov.prweather.feature.details.factory.WeatherEntityBuilder
import com.gahov.prweather.feature.details.factory.WeatherEntityToModelBuilder
import com.gahov.prweather.feature.selector.factory.CityEntityBuilder
import com.gahov.prweather.feature.selector.factory.WeatherListToCityModelBuilder
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class EntityBuilderModule {

    @Provides
    @Reusable
    internal fun provideWeatherEntityBuilder(
        context: Context
    ): WeatherEntityBuilder =
        WeatherEntityToModelBuilder(context)

    @Provides
    @Reusable
    internal fun provideCityEntityBuilder(): CityEntityBuilder =
        WeatherListToCityModelBuilder()
}