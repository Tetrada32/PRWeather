package com.gahov.prweather.data.test.base.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * A utility object for creating Retrofit instances during tests.
 */
object RetrofitHelper {

    val client = OkHttpClient.Builder().build()

    /**
     * Creates a Retrofit instance for the specified API service interface.
     *
     * @param T The type of the API service interface.
     * @param localServerUrl The base URL for the local mock server.
     * @param networkServerUrl The base URL for the network server (real server).
     * @param useRealRequests Determines whether to use real network requests or local mock server requests.
     * @return An instance of the Retrofit API service interface.
     */
    inline fun <reified T> testApiInstance(
        localServerUrl: String,
        networkServerUrl: String,
        useRealRequests: Boolean
    ): T {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .baseUrl(
                if (useRealRequests) {
                    networkServerUrl
                } else {
                    localServerUrl
                }
            ).build()
            .create(T::class.java)
    }
}