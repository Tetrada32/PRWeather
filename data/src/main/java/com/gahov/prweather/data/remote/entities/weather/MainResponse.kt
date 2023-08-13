package com.gahov.prweather.data.remote.entities.weather

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class MainResponse(
    @SerialName("temp")
    val temperature: Double? = null,

    @SerialName("feels_like")
    val feelsLike: Double? = null,

    @SerialName("temp_min")
    val tempMin: Double? = null,

    @SerialName("temp_max")
    val tempMax: Double? = null,

    @SerialName("pressure")
    val pressure: Int? = null,

    @SerialName("humidity")
    val humidity: Int? = null
)