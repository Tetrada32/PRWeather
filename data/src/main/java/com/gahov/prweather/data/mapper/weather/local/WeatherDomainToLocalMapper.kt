package com.gahov.prweather.data.mapper.weather.local

import com.gahov.prweather.data.local.entities.WeatherDTO
import com.gahov.prweather.data.mapper.common.DbMapper
import com.gahov.prweather.domain.entities.weather.WeatherEntity


class WeatherDomainToLocalMapper : DbMapper<WeatherEntity, WeatherDTO> {

    override fun toDatabase(domainModel: WeatherEntity): WeatherDTO {
        return WeatherDTO(
            id = domainModel.id?.toLong(),
            cityName = domainModel.cityName,
            countryName = domainModel.countryName,
            weatherDescription = domainModel.weatherDescription,
            temperatureKelvin = domainModel.temperatureKelvin,
            humidity = domainModel.humidity,
            windSpeed = domainModel.windSpeed,
            iconId = domainModel.iconId,
            time = domainModel.time
        )
    }

    override fun toDomain(dbModel: WeatherDTO): WeatherEntity {
        return WeatherEntity(
            id = dbModel.id?.toInt(),
            cityName = dbModel.cityName,
            countryName = dbModel.countryName,
            weatherDescription = dbModel.weatherDescription,
            temperatureKelvin = dbModel.temperatureKelvin,
            humidity = dbModel.humidity,
            windSpeed = dbModel.windSpeed,
            iconId = dbModel.iconId,
            time = dbModel.time
        )
    }
}