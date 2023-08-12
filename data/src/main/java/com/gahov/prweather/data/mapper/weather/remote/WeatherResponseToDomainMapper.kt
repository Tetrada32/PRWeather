package com.gahov.prweather.data.mapper.weather.remote

import com.gahov.prweather.data.mapper.common.ApiMapper
import com.gahov.prweather.data.remote.entities.weather.WeatherDataResponse
import com.gahov.prweather.domain.entities.weather.WeatherEntity


class WeatherResponseToDomainMapper : ApiMapper<WeatherDataResponse, WeatherEntity> {
    override fun toDomain(apiModel: WeatherDataResponse): WeatherEntity {
        return WeatherEntity(
            id = apiModel.id,
            cityName = apiModel.cityName,
            countryName = apiModel.sys?.country,
            weatherDescription = apiModel.weather?.get(0)?.description,
            temperatureCelsius = apiModel.main?.temperature,
            humidity = apiModel.main?.humidity,
            windSpeed = apiModel.wind?.speed
        )
    }
}