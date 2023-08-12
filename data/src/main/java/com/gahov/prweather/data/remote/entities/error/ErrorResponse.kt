package com.gahov.prweather.data.remote.entities.error

import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName("cod")
    val responseCode: Int? = null,

    @SerializedName("message")
    val errorMessage: String? = null
)
