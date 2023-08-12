package com.gahov.prweather.domain.entities.failure

sealed class ServerError : Failure.FeatureFailure() {

    object ServerCommon : ServerError()

}