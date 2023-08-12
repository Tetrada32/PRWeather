package com.gahov.prweather.data.repository.weather

import com.gahov.prweather.data.mapper.weather.remote.WeatherResponseToDomainMapper
import com.gahov.prweather.data.source.weather.remote.WeatherRemoteSource
import com.gahov.prweather.domain.entities.common.Either
import com.gahov.prweather.domain.entities.failure.Failure
import com.gahov.prweather.domain.entities.weather.WeatherEntity
import com.gahov.prweather.domain.repository.weather.WeatherRepository

class ImplWeatherRepository constructor(
    private val remoteSource: WeatherRemoteSource,
    private val weatherRemoteMapper: WeatherResponseToDomainMapper
) : WeatherRepository {

    override suspend fun loadCityWeatherByName(cityName: String): Either<Failure, WeatherEntity> {
        return when (val result = remoteSource.loadCityWeatherByName(cityName)) {
            is Either.Left -> result
            is Either.Right -> Either.Right(weatherRemoteMapper.toDomain(result.success))
        }
    }
}