package com.gahov.prweather.data.mapper.error

import com.gahov.prweather.data.remote.entities.error.ErrorResponse
import com.gahov.prweather.domain.common.converter.Mapper
import com.gahov.prweather.domain.entities.failure.ErrorEntity


object ErrorEventMapper {
    class ErrorMessageResponseToEntity : Mapper<ErrorResponse, ErrorEntity>() {
        override fun map(from: ErrorResponse): ErrorEntity {
            return ErrorEntity(
                message = from.errorMessage.orEmpty(),
                code = from.responseCode ?: 401
            )
        }
    }
}