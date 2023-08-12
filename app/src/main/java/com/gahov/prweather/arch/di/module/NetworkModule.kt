package com.gahov.prweather.arch.di.module

import android.content.SharedPreferences
import com.gahov.prweather.arch.component.device.AndroidSystemInfo
import com.gahov.prweather.data.source.auth.impl.ImplTokenSource
import com.gahov.prweather.data.local.storage.authorization.ImplAuthorizationLocalStorage
import com.gahov.prweather.data.remote.configuration.NetworkConfiguration
import com.gahov.prweather.data.remote.configuration.NetworkFactory
import com.gahov.prweather.data.remote.configuration.interceptor.provider.DefaultInterceptorProvider
import com.gahov.prweather.data.remote.configuration.interceptor.utils.token.BearerProvider
import com.gahov.prweather.data.remote.configuration.interceptor.utils.token.TokenProvider
import com.gahov.prweather.data.remote.protocol.WeatherProtocol
import com.gahov.prweather.data.remote.url.BaseUrlProvider
import com.gahov.prweather.data.remote.url.UrlProvider
import com.gahov.prweather.domain.component.device.DeviceSystemInfo
import com.gahov.prweather.domain.component.device.UserAgent
import com.gahov.prweather.domain.component.device.UserAgentProvider
import com.gahov.prweather.domain.component.logger.Logger
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    internal fun provideNetworkFactory(
        configuration: NetworkConfiguration.DefaultConfiguration,
        interceptor: DefaultInterceptorProvider
    ): NetworkFactory {
        return NetworkFactory(
            configuration = configuration,
            interceptor = interceptor
        )
    }

    @Provides
    @Singleton
    internal fun provideDefaultInterceptor(
        configuration: NetworkConfiguration.DefaultConfiguration,
        userAgent: UserAgentProvider,
        logger: Logger,
    ) = DefaultInterceptorProvider(
        configuration = configuration,
        userAgentProvider = userAgent,
        logger = logger
    )

    @Provides
    @Singleton
    internal fun provideDefaultAuthConfiguration(
        tokenProvider: TokenProvider,
        urlProvider: UrlProvider,
    ) = NetworkConfiguration.DefaultConfiguration(
        serverUrlProvider = urlProvider,
    )

    @Provides
    @Singleton
    internal fun provideTokenProvider(
        sharedPreferences: SharedPreferences
    ): TokenProvider = BearerProvider(
        tokenSource = ImplTokenSource(
            storage =
            ImplAuthorizationLocalStorage(preferences = sharedPreferences)
        )
    )

    @Provides
    @Singleton
    internal fun provideServerUrlProvider(): UrlProvider = BaseUrlProvider()

    @Provides
    @Singleton
    internal fun provideUserAgent(
        deviceSystemInfo: DeviceSystemInfo
    ): UserAgentProvider = UserAgent(deviceSystemInfo = deviceSystemInfo)

    @Provides
    @Singleton
    internal fun provideSystemInfo(): DeviceSystemInfo = object : AndroidSystemInfo() {
    }

    @Provides
    @Reusable
    internal fun provideNewsProtocol(
        configuration: NetworkConfiguration.DefaultConfiguration,
        interceptor: DefaultInterceptorProvider
    ): WeatherProtocol {
        return NetworkFactory.createService(
            protocol = WeatherProtocol::class.java,
            configuration = configuration,
            interceptors = interceptor
        )
    }
}