package com.gahov.prweather.data.mapper.error

import com.gahov.prweather.data.remote.entities.error.ErrorResponse
import com.gahov.prweather.domain.common.converter.Mapper
import com.gahov.prweather.domain.entities.failure.ErrorEntity

/**
 * An object providing mapping functions for converting error-related data.
 */

object ErrorEventMapper {

    /**
     * An inner class for mapping from [ErrorResponse] to [ErrorEntity].
     */
    class ErrorMessageResponseToEntity : Mapper<ErrorResponse, ErrorEntity>() {

        /**
         * Converts an [ErrorResponse] to an [ErrorEntity].
         *
         * @param from The [ErrorResponse] object to be converted.
         * @return The resulting [ErrorEntity] object.
         */
        override fun map(from: ErrorResponse): ErrorEntity {
            return ErrorEntity(
                message = from.errorMessage.orEmpty(),
                code = from.responseCode ?: 401
            )
        }
    }
}