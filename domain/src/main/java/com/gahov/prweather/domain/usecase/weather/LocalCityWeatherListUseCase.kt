package com.gahov.prweather.domain.usecase.weather

import com.gahov.prweather.domain.common.usecase.AsyncUseCase
import com.gahov.prweather.domain.common.usecase.UseCase
import com.gahov.prweather.domain.entities.common.Either
import com.gahov.prweather.domain.entities.failure.Failure
import com.gahov.prweather.domain.entities.weather.WeatherEntity
import com.gahov.prweather.domain.repository.weather.WeatherRepository

class LocalCityWeatherListUseCase(
    private val repository: WeatherRepository
) : AsyncUseCase<List<WeatherEntity>>() {

    override suspend fun execute(param: UseCase.Params?): Either<Failure, List<WeatherEntity>> {
        return repository.getCitiesWeatherList()
    }
}