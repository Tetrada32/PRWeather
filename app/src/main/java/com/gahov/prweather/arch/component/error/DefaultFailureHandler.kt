package com.gahov.prweather.arch.component.error

import android.content.Context
import android.widget.Toast
import com.gahov.prweather.R
import com.gahov.prweather.domain.component.logger.Level
import com.gahov.prweather.domain.component.logger.Logger
import com.gahov.prweather.domain.entities.failure.Failure
import com.gahov.prweather.domain.entities.failure.ServerError

open class DefaultFailureHandler(
    private val context: Context,
    private val logger: Logger
) : ErrorHandler {

    override fun parseFailure(failure: Failure) {
        when (failure) {
            is Failure.Common -> commonFailure(failure)
            is Failure.CoroutineException -> logError(failure.throwable)
            is Failure.DataSourceException -> logError(failure.throwable)
            is Failure.FeatureFailure -> featureFailure(failure)
            else -> logger.log(
                level = Level.Error,
                message = failure.toString()
            )
        }
    }

    private fun commonFailure(failure: Failure.Common) {
        val message = failure.throwable?.message
        if (message.isNullOrEmpty()) {
            logWarning(failure.toString())
        } else {
            logWarning(message)
        }
    }

    protected open fun featureFailure(failure: Failure.FeatureFailure) {
        when (failure) {
            is ServerError.ServerCodeError -> handleServerCodeError(failure.error.message)
            else -> handleNonServerCodeError()
        }
    }

    private fun handleServerCodeError(error: String) {
        context.let { context ->
            Toast.makeText(
                context.applicationContext,
                error,
                Toast.LENGTH_SHORT
            ).show()
        }

        logger.log(
            level = Level.Error,
            message = "An server error occurred: $error"
        )
    }

    private fun handleNonServerCodeError() {
        context.let { context ->
            Toast.makeText(
                context.applicationContext,
                context.getString(R.string.default_error_message),
                Toast.LENGTH_SHORT
            ).show()
        }
        logger.log(
            level = Level.Error,
            message = "An unknown error occurred"
        )
    }

    private fun logWarning(errorMessage: String) {
        logger.log(level = Level.Warning, message = errorMessage)
    }

    private fun logError(throwable: Throwable) {
        logger.log(level = Level.Error, message = throwable.message, throwable = throwable)
    }
}