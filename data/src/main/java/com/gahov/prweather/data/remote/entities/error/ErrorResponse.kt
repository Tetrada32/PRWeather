package com.gahov.prweather.data.remote.entities.error

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponse(
    @SerialName("cod")
    val responseCode: Int? = null,

    @SerialName("message")
    val errorMessage: String? = null
)
