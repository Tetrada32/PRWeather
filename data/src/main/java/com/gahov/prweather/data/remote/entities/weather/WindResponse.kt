package com.gahov.prweather.data.remote.entities.weather

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class WindResponse(
    @SerializedName("speed")
    val speed: Double? = null,

    @SerializedName("deg")
    val deg: Int? = null,

    @SerializedName("gust")
    val gust: Double? = null
)