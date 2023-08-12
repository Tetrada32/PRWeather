package com.gahov.prweather.arch.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gahov.prweather.arch.di.ViewModelFactory
import com.gahov.prweather.arch.di.ViewModelKey
import com.gahov.prweather.feature.details.CityWeatherDetailsViewModel
import com.gahov.prweather.feature.history.WeatherHistoryViewModel
import com.gahov.prweather.feature.main.MainViewModel
import com.gahov.prweather.feature.selector.CitySelectorViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap

@Module
@InstallIn(SingletonComponent::class)
internal abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CitySelectorViewModel::class)
    abstract fun bindCitySelectorViewModel(viewModel: CitySelectorViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CityWeatherDetailsViewModel::class)
    abstract fun bindCityWeatherDetailsViewModel(viewModel: CityWeatherDetailsViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(WeatherHistoryViewModel::class)
    abstract fun bindWeatherHistoryViewModel(viewModel: WeatherHistoryViewModel): ViewModel

}