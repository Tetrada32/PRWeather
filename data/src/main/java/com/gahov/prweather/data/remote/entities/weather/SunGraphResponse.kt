package com.gahov.prweather.data.remote.entities.weather

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class SunGraphResponse(
    @SerializedName("type")
    val type: Int? = null,

    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("country")
    val country: String? = null,

    @SerializedName("sunrise")
    val sunrise: Long? = null,

    @SerializedName("sunset")
    val sunset: Long? = null
)