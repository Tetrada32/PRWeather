package com.gahov.prweather.arch.component.error

import com.gahov.prweather.domain.entities.failure.Failure


interface ErrorHandler {

    fun parseFailure(failure: Failure)
}