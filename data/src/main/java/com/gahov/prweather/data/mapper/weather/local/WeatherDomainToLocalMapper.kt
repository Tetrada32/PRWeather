package com.gahov.prweather.data.mapper.weather.local

import com.gahov.prweather.data.local.entities.WeatherDTO
import com.gahov.prweather.data.mapper.common.DbMapper
import com.gahov.prweather.domain.entities.weather.WeatherEntity

/**
 * A class providing mapping functions for converting weather domain model data to and from
 * local database model data.
 */

class WeatherDomainToLocalMapper : DbMapper<WeatherEntity, WeatherDTO> {

    /**
     * Converts a weather domain model to the corresponding local database model.
     *
     * @param domainModel The weather domain model to be converted.
     * @return The resulting local database model [WeatherDTO].
     */
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

    /**
     * Converts a local database model [WeatherDTO] to the corresponding weather domain model.
     *
     * @param dbModel The local database model [WeatherDTO] to be converted.
     * @return The resulting weather domain model [WeatherEntity].
     */
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