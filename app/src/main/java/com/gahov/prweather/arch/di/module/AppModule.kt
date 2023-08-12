package com.gahov.prweather.arch.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module(
    includes = [
        RepositoryModule::class,
        SourceModule::class,
        MapperModule::class,
        ViewModelModule::class,
        LoggerModule::class,
        SharedPreferencesModule::class,
        EntityBuilderModule::class,
        DatabaseModule::class
    ]
)
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    internal fun provideApplicationContext(application: Application): Context {
        return application.applicationContext
    }
}