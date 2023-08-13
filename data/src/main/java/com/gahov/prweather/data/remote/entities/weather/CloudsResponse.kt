package com.gahov.prweather.data.remote.entities.weather

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CloudsResponse(

    @SerialName("all")
    val all: Int? = null
)