package com.gahov.prweather.data.local.storage.authorization

import android.content.SharedPreferences
import com.gahov.prweather.data.common.exception.BasePreferences

class ImplAuthorizationLocalStorage(
    preferences: SharedPreferences,
) : AuthorizationLocalStorage, BasePreferences(preferences) {

    override var accessToken: String
        get() = get(KEY_ACCESS_TOKEN, "")
        set(value) = put(KEY_ACCESS_TOKEN, value)

    companion object {
        private const val KEY_ACCESS_TOKEN = "key_access_token"
    }
}