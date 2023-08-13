package com.gahov.prweather.domain.usecase.weather

import com.gahov.prweather.domain.common.usecase.AsyncUseCase
import com.gahov.prweather.domain.common.usecase.UseCase
import com.gahov.prweather.domain.entities.common.Either
import com.gahov.prweather.domain.entities.failure.Failure
import com.gahov.prweather.domain.entities.weather.CityWeatherParams
import com.gahov.prweather.domain.entities.weather.WeatherEntity
import com.gahov.prweather.domain.repository.weather.WeatherRepository

class LoadRemoteCityWeatherUseCase(
    private val repository: WeatherRepository
) : AsyncUseCase<WeatherEntity>() {

    override suspend fun execute(param: UseCase.Params?): Either<Failure, WeatherEntity> {
        val params = param as? CityWeatherParams
        return repository.loadCityWeatherByName(params?.cityName.toString())
    }
}