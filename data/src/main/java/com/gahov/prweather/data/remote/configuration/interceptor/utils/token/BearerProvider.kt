package com.gahov.prweather.data.remote.configuration.interceptor.utils.token

import com.gahov.prweather.data.local.entities.TokenData
import com.gahov.prweather.data.source.auth.TokenSource

class BearerProvider(
    private val tokenSource: TokenSource,
) : TokenProvider {

    @Synchronized
    override fun getToken() = tokenSource.getToken()?.accessToken

    @Synchronized
    override fun setToken(tokenData: TokenData) {
        tokenSource.updateToken(tokenData)
    }
}