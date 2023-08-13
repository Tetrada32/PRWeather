package com.gahov.prweather.data.remote.entities.weather

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    @SerialName("id")
    val id: Int? = null,

    @SerialName("main")
    val main: String? = null,

    @SerialName("description")
    val description: String? = null,

    @SerialName("icon")
    val icon: String? = null
)