package com.gahov.prweather.data.repository.weather

import com.gahov.prweather.data.mapper.weather.local.WeatherDomainToLocalMapper
import com.gahov.prweather.data.mapper.weather.remote.WeatherResponseToDomainMapper
import com.gahov.prweather.data.remote.entities.weather.WeatherDataResponse
import com.gahov.prweather.data.source.weather.local.WeatherLocalSource
import com.gahov.prweather.data.source.weather.remote.WeatherRemoteSource
import com.gahov.prweather.domain.entities.common.Either
import com.gahov.prweather.domain.entities.failure.Failure
import com.gahov.prweather.domain.entities.weather.WeatherEntity
import com.gahov.prweather.domain.repository.weather.WeatherRepository

class ImplWeatherRepository constructor(
    private val remoteSource: WeatherRemoteSource,
    private val localSource: WeatherLocalSource,
    private val weatherRemoteMapper: WeatherResponseToDomainMapper,
    private val weatherLocalMapper: WeatherDomainToLocalMapper
) : WeatherRepository {

    override suspend fun loadRemoteCityWeatherByName(cityName: String): Either<Failure, WeatherEntity> {
        return when (val result = remoteSource.loadCityWeatherByName(cityName)) {
            is Either.Left -> result
            is Either.Right -> Either.Right(processAndSaveSuccessResult(result.success))
        }
    }

    private suspend fun processAndSaveSuccessResult(result: WeatherDataResponse): WeatherEntity {
        val mappedResult = weatherRemoteMapper.toDomain(result)
        saveCityWeatherData(mappedResult)
        return mappedResult
    }

    override suspend fun saveCityWeatherData(weather: WeatherEntity) {
        val mappedItem = weatherLocalMapper.toDatabase(weather)
        localSource.saveWeather(mappedItem)
    }

    override suspend fun getCitiesWeatherList(cityName: String): Either<Failure, List<WeatherEntity>> {
        return try {
            val cashedCitiesWeatherList = localSource.getAllWeatherData(cityName)
            Either.Right(cashedCitiesWeatherList.map { weatherLocalMapper.toDomain(it) })
        } catch (e: Exception) {
            e.printStackTrace()
            Either.Left(Failure.Common(e.fillInStackTrace()))
        }
    }

    override suspend fun deleteLocalCity(cityName: String): Either<Failure, List<WeatherEntity>> {
        localSource.deleteAllWeatherData(cityName)
        return getCitiesWeatherList()
    }
}