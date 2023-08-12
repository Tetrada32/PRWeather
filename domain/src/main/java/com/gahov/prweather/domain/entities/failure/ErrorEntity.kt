package com.gahov.prweather.domain.entities.failure

data class ErrorEntity(
    val code: Int? = 401,
    val message: String = ""
)