package com.gahov.prweather.data.remote.url

/**
 * A class providing the base URL for network requests.
 */
class BaseUrlProvider : UrlProvider {
    override fun getBaseUrl(): String {
        return BASE_URL
    }

    companion object {
        /**
         * The base URL hardcoded for network requests.
         */
        const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
    }
}