package com.gahov.prweather.data.remote.entities.weather

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class CoordinatesResponse(
    @SerializedName("lon")
    val longitude: Double? = null,

    @SerializedName("lat")
    val latitude: Double? = null
)