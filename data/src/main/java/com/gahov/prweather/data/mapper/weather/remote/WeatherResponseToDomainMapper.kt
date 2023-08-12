package com.gahov.prweather.data.mapper.weather.remote

import com.gahov.prweather.data.common.util.DateUtil.formatCurrentTimeWithOffset
import com.gahov.prweather.data.mapper.common.ApiMapper
import com.gahov.prweather.data.remote.entities.weather.WeatherDataResponse
import com.gahov.prweather.data.remote.entities.weather.WeatherResponse
import com.gahov.prweather.domain.entities.weather.WeatherEntity


class WeatherResponseToDomainMapper : ApiMapper<WeatherDataResponse, WeatherEntity> {
    override fun toDomain(apiModel: WeatherDataResponse): WeatherEntity {
        return WeatherEntity(
            id = apiModel.id,
            cityName = apiModel.name,
            countryName = apiModel.sys?.country,
            weatherDescription = getFirstWeatherItem(apiModel.weather).description,
            temperatureKelvin = apiModel.main?.temperature,
            humidity = apiModel.main?.humidity,
            windSpeed = apiModel.wind?.speed,
            iconId = getFirstWeatherItem(apiModel.weather).icon,
            time = formatCurrentTimeWithOffset(apiModel.timezone)
        )
    }

    private fun getFirstWeatherItem(weatherList: List<WeatherResponse>?): WeatherResponse {
        if (!weatherList.isNullOrEmpty()) {
            return weatherList[0]
        } else {
            throw Exception()
        }
    }
}