package com.gahov.prweather.data.source.auth

import com.gahov.prweather.data.local.entities.TokenData
import com.gahov.prweather.domain.source.Source

interface TokenSource : Source {

    fun getToken(): TokenData

    fun updateToken(tokenData: TokenData)

    suspend fun clearToken()

}