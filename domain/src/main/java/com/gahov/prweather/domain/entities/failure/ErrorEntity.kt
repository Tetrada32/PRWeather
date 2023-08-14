package com.gahov.prweather.domain.entities.failure

/**
 * A data class representing an error entity with code and message.
 *
 * @property code The error code associated with the error entity. Default value is 401.
 * @property message The error message associated with the error entity.
 */
data class ErrorEntity(
    val code: Int? = 401,
    val message: String = ""
)