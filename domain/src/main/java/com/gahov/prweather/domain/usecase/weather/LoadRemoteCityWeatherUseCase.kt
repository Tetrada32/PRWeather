package com.gahov.prweather.domain.usecase.weather

import com.gahov.prweather.domain.common.usecase.AsyncUseCase
import com.gahov.prweather.domain.common.usecase.UseCase
import com.gahov.prweather.domain.entities.common.Either
import com.gahov.prweather.domain.entities.failure.Failure
import com.gahov.prweather.domain.entities.weather.CityWeatherParams
import com.gahov.prweather.domain.entities.weather.WeatherEntity
import com.gahov.prweather.domain.repository.weather.WeatherRepository

/**
 * A use case class that handles loading weather information for a remote city.
 *
 * @param repository The repository responsible for data access related to weather information.
 * @constructor Creates a LoadRemoteCityWeatherUseCase with the provided [repository].
 */

class LoadRemoteCityWeatherUseCase(
    private val repository: WeatherRepository
) : AsyncUseCase<WeatherEntity>() {

    /**
     * Executes the use case to load weather information for a specified remote city.
     *
     * @param param The parameters for executing the use case, which should be of type [CityWeatherParams].
     * @return An [Either] instance containing either a [Failure] if the operation fails, or a
     * single [WeatherEntity] representing the loaded remote weather information.
     *
     * See [Either] details.
     */
    override suspend fun execute(param: UseCase.Params?): Either<Failure, WeatherEntity> {
        val params = param as? CityWeatherParams
        return repository.loadRemoteCityWeatherByName(params?.cityName.toString())
    }
}