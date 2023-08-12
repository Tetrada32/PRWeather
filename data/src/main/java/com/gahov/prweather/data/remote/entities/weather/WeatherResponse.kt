package com.gahov.prweather.data.remote.entities.weather

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("main")
    val main: String? = null,

    @SerializedName("description")
    val description: String? = null,

    @SerializedName("icon")
    val icon: String? = null
)