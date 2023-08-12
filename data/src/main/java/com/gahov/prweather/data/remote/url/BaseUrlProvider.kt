package com.gahov.prweather.data.remote.url

class BaseUrlProvider : UrlProvider {
    override fun getBaseUrl(): String {
        return BASE_URL
    }

    companion object {
        const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
    }
}