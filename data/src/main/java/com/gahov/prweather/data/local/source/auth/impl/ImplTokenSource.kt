package com.gahov.prweather.data.local.source.auth.impl

import com.gahov.prweather.data.local.entities.TokenData
import com.gahov.prweather.data.local.source.auth.TokenSource
import com.gahov.prweather.data.local.storage.authorization.AuthorizationLocalStorage

class ImplTokenSource(
    private val storage: AuthorizationLocalStorage,
) : TokenSource {

    override fun getToken(): TokenData {
        return TokenData(
            accessToken = storage.accessToken
        )
    }

    override fun updateToken(tokenData: TokenData) {
        storage.accessToken = tokenData.accessToken
    }

    override suspend fun clearToken() {
        storage.apply {
            accessToken = ""
        }
    }
}