package com.gahov.prweather.data.remote.entities.weather

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoordinatesResponse(
    @SerialName("lon")
    val longitude: Double? = null,

    @SerialName("lat")
    val latitude: Double? = null
)