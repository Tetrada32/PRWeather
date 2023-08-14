package com.gahov.prweather.data.remote.url

/**
 * An interface representing a provider for base URLs.
 */
interface UrlProvider {

    /**
     * Retrieves the base URL.
     *
     * @return The base URL as a string.
     */
    fun getBaseUrl(): String
}