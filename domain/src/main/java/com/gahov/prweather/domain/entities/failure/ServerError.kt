package com.gahov.prweather.domain.entities.failure

/**
 * A sealed class representing different types of server-related errors that can occur in the application.
 * For example, if server returned expected friendly error "city not found: 401"
 * See [ErrorEntity]
 */

sealed class ServerError : Failure.FeatureFailure() {

    object ServerCommon : ServerError()

    data class ServerCodeError(val code: Int, val error: ErrorEntity) : ServerError()

}