package com.gahov.prweather.data.remote.entities.weather

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherDataResponse(
    @SerialName("coord")
    val coordinates: CoordinatesResponse? = null,

    @SerialName("weather")
    val weather: List<WeatherResponse>? = null,

    @SerialName("base")
    val base: String? = null,

    @SerialName("main")
    val main: MainResponse? = null,

    @SerialName("visibility")
    val visibility: Int? = null,

    @SerialName("wind")
    val wind: WindResponse? = null,

    @SerialName("clouds")
    val clouds: CloudsResponse? = null,

    @SerialName("dt")
    val dt: Long? = null,

    @SerialName("sys")
    val sys: SunGraphResponse? = null ,

    @SerialName("timezone")
    val timezone: Int? = null,

    @SerialName("id")
    val id: Int? = null,

    @SerialName("name")
    val name: String? = null,

    @SerialName("cod")
    val code: Int? = null
)