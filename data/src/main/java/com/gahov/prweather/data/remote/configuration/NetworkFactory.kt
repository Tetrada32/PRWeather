package com.gahov.prweather.data.remote.configuration

import com.gahov.prweather.data.remote.configuration.interceptor.provider.InterceptorProvider
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

/**
 * A factory class for creating network services using Retrofit and OkHttpClient.
 *
 * @param configuration The network configuration settings.
 * @param interceptor The interceptor provider for adding interceptors.
 */
class NetworkFactory(
    private val configuration: NetworkConfiguration,
    private val interceptor: InterceptorProvider,
) {

    /**
     * Creates a service implementation for the given protocol using Retrofit.
     *
     * @param protocol The protocol interface to be implemented.
     * @return An instance of the service implementation.
     */
    private fun <S> createService(protocol: Class<S>): S {
        return retrofit.create(protocol)
    }

    private val retrofit: Retrofit
        get() = Retrofit.Builder()
            .baseUrl(configuration.serverUrlProvider.getBaseUrl())
            .addConverterFactory(configuration.converterFactoryProvider.converterFactory)
            .client(okHttpClient)
            .build()

    private val okHttpClient: OkHttpClient
        get() = OkHttpClient.Builder().apply {
            connectTimeout(configuration.timeout, TimeUnit.MILLISECONDS)
            writeTimeout(configuration.timeout, TimeUnit.MILLISECONDS)
            readTimeout(configuration.timeout, TimeUnit.MILLISECONDS)
            interceptor.interceptors.forEach {
                addInterceptor(it)
            }
            interceptor.networkInterceptors.forEach {
                addNetworkInterceptor(it)
            }
        }.build()

    companion object {
        /**
         * Creates a service implementation for the given protocol using the factory.
         *
         * @param protocol The protocol interface to be implemented.
         * @param configuration The network configuration settings.
         * @param interceptors The interceptor provider for adding interceptors.
         * @return An instance of the service implementation.
         */
        fun <S> createService(
            protocol: Class<S>,
            configuration: NetworkConfiguration,
            interceptors: InterceptorProvider,
        ): S {
            return NetworkFactory(
                configuration = configuration,
                interceptor = interceptors
            ).createService(protocol = protocol)
        }
    }
}