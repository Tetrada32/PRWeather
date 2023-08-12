package com.gahov.prweather.data.remote.configuration.interceptor.utils.token

import com.gahov.prweather.data.local.entities.TokenData

interface TokenProvider {

    fun getToken(): String?

    fun setToken(tokenData: TokenData)
}