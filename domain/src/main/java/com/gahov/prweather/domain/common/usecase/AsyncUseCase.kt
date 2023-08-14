package com.gahov.prweather.domain.common.usecase

import com.gahov.prweather.domain.entities.common.Either
import com.gahov.prweather.domain.entities.failure.Failure

/**
 * An abstract base class for asynchronous use cases that perform operations and return results.
 *
 * @param Result The type of result that the use case will produce.
 * @constructor Creates an [AsyncUseCase] instance.
 */
abstract class AsyncUseCase<out Result : Any> : UseCase<Result> {

    /**
     * Executes the asynchronous use case operation.
     *
     * @param param The parameters for executing the use case, which should be of type [UseCase.Params].
     * @return An [Either] instance containing either a [Failure] if the operation fails, or a result of type [Result].
     */
    abstract suspend fun execute(param: UseCase.Params? = null): Either<Failure, Result>

    /**
     * Invokes the asynchronous use case with optional parameters and a callback for the result.
     *
     * @param param The parameters for executing the use case, which should be of type [UseCase.Params].
     * @param onResult A callback function that will be invoked with the result of the use case operation.
     */
    suspend operator fun invoke(
        param: UseCase.Params? = null,
        onResult: (Either<Failure, Result>) -> Unit = {},
    ) {
        onResult(execute(param))
    }
}