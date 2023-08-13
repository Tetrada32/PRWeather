package com.gahov.prweather.data.test.base.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitHelper {

    val client = OkHttpClient.Builder().build()

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