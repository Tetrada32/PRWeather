package com.gahov.prweather.domain.usecase.weather

import com.gahov.prweather.domain.common.usecase.AsyncUseCase
import com.gahov.prweather.domain.common.usecase.UseCase
import com.gahov.prweather.domain.entities.common.Either
import com.gahov.prweather.domain.entities.failure.Failure
import com.gahov.prweather.domain.entities.weather.CityWeatherParams
import com.gahov.prweather.domain.entities.weather.WeatherEntity
import com.gahov.prweather.domain.repository.weather.WeatherRepository

/**
 * A use case class that handles the deletion of a local city's weather information.
 *
 * @param repository The repository responsible for data access related to weather information.
 * @constructor Creates a DeleteLocalCityUseCase with the provided [repository].
 */
class DeleteLocalCityUseCase(
    private val repository: WeatherRepository
) : AsyncUseCase<List<WeatherEntity>>() {


    /**
     * Executes the use case to delete weather information for a specified city.
     *
     * @param param The parameters for executing the use case, which should be of type [CityWeatherParams].
     * @return An [Either] instance containing either a [Failure] if the operation fails, or a [List]
     * of [WeatherEntity] representing the deleted weather information.
     *
     * See [Either] details.
     */
    override suspend fun execute(param: UseCase.Params?): Either<Failure, List<WeatherEntity>> {
        val params = param as? CityWeatherParams
        return repository.deleteLocalCity(params?.cityName ?: "")
    }
}