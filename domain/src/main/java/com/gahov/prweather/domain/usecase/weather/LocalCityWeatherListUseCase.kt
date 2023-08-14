package com.gahov.prweather.domain.usecase.weather

import com.gahov.prweather.domain.common.usecase.AsyncUseCase
import com.gahov.prweather.domain.common.usecase.UseCase
import com.gahov.prweather.domain.entities.common.Either
import com.gahov.prweather.domain.entities.failure.Failure
import com.gahov.prweather.domain.entities.weather.CityWeatherParams
import com.gahov.prweather.domain.entities.weather.WeatherEntity
import com.gahov.prweather.domain.repository.weather.WeatherRepository

/**
 * A use case class that handles retrieving a list of weather information for local cities.
 *
 * @param repository The repository responsible for data access related to weather information.
 * @constructor Creates a LocalCityWeatherListUseCase with the provided [repository].
 */
class LocalCityWeatherListUseCase(
    private val repository: WeatherRepository
) : AsyncUseCase<List<WeatherEntity>>() {

    /**
     * Executes the use case to retrieve weather information for a list of local cities.
     *
     * @param param The parameters for executing the use case, which should be of type [CityWeatherParams].
     * @return An [Either] instance containing either a [Failure] if the operation fails, or a
     * [List] of [WeatherEntity] representing the weather information for the list of local cities.
     *It can help to update current state list after the operation. The @return is not asynchronous!
     */
    override suspend fun execute(param: UseCase.Params?): Either<Failure, List<WeatherEntity>> {
        val params = param as? CityWeatherParams
        return repository.getCitiesWeatherList(params?.cityName ?: "")
    }
}