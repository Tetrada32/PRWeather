package com.gahov.prweather.data.remote.entities.weather

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherDataResponse(
    @SerializedName("coord")
    val coordinates: CoordinatesResponse? = null,

    @SerializedName("weather")
    val weather: List<WeatherResponse>? = null,

    @SerializedName("base")
    val base: String? = null,

    @SerializedName("main")
    val main: MainResponse? = null,

    @SerializedName("visibility")
    val visibility: Int? = null,

    @SerializedName("wind")
    val wind: WindResponse? = null,

    @SerializedName("clouds")
    val clouds: CloudsResponse? = null,

    @SerializedName("dt")
    val dt: Long? = null,

    @SerializedName("sys")
    val sys: SunGraphResponse? = null ,

    @SerializedName("timezone")
    val timezone: Int? = null,

    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("cod")
    val code: Int? = null
)