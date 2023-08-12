package com.gahov.prweather.data.remote.entities.weather

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class CloudsResponse(

    @SerializedName("all")
    val all: Int? = null
)