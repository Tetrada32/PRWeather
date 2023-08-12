package com.gahov.prweather.arch.di.component

import android.app.Application
import com.gahov.prweather.PlanRadarWeatherApplication
import com.gahov.prweather.arch.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.MembersInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class
    ]
)
interface AppComponent : MembersInjector<PlanRadarWeatherApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder

        fun build(): AppComponent
    }
}