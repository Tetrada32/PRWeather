package com.gahov.prweather.arch.controller

import com.gahov.prweather.domain.entities.failure.Failure

interface Controller {

    fun setLoading(boolean: Boolean)

    fun handleFailure(failure: Failure)

}