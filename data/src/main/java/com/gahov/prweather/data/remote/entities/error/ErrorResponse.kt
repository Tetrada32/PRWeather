package com.gahov.prweather.data.remote.entities.error

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A data class representing an error response from an API.
 *
 * @property responseCode The response code indicating the type of error.
 * @property errorMessage The error message describing the issue.
 */

@Serializable
data class ErrorResponse(
    @SerialName("cod")
    val responseCode: Int? = null,

    @SerialName("message")
    val errorMessage: String? = null
)
