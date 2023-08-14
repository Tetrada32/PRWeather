package com.gahov.prweather.data.remote.entities.weather

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A data class representing weather data from an API response.
 * It is the main API response POJO.
 *
 * @property coordinates The coordinates of the location.
 * @property weather The list of weather conditions.
 * @property base The base parameter of the API response.
 * @property main The main weather data details.
 * @property visibility The visibility value.
 * @property wind The wind information.
 * @property clouds The cloud information.
 * @property dt The date and time of the data.
 * @property sys The sun and graph data.
 * @property timezone The timezone offset.
 * @property id The ID of the data.
 * @property name The name of the location.
 * @property code The response code.
 */

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