package com.gahov.prweather.data.local.storage.authorization


/**
 * An interface for managing authorization-related data storage.
 */
interface AuthorizationLocalStorage {

    /**
     * The access token associated with the user's authorization.
     */
    var accessToken: String?
}