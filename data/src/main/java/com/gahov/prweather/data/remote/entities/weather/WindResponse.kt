package com.gahov.prweather.data.remote.entities.weather

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WindResponse(
    @SerialName("speed")
    val speed: Double? = null,

    @SerialName("deg")
    val deg: Int? = null,

    @SerialName("gust")
    val gust: Double? = null
)