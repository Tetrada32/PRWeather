package com.gahov.prweather.arch.di.module

import android.content.Context
import com.gahov.prweather.arch.component.error.DefaultFailureHandler
import com.gahov.prweather.arch.component.error.ErrorHandler
import com.gahov.prweather.arch.component.logger.AndroidLogger
import com.gahov.prweather.domain.component.logger.Logger
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LoggerModule {

    @Provides
    @Singleton
    internal fun provideLogger(): Logger {
        return AndroidLogger()
    }

    @Provides
    @Singleton
    internal fun provideErrorHandler(context: Context, logger: Logger): ErrorHandler {
        return DefaultFailureHandler(context = context, logger = logger)
    }
}