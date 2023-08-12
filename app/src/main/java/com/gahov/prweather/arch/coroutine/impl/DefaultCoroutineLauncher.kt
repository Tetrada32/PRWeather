package com.gahov.prweather.arch.coroutine.impl

import com.gahov.prweather.arch.coroutine.CoroutineLauncher
import com.gahov.prweather.domain.entities.failure.Failure
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope

class DefaultCoroutineLauncher(
    private val scope: CoroutineScope,
    handleFailure: ((Failure) -> Unit)? = null
) : CoroutineLauncher {

    override fun launch(supervisor: Boolean, block: suspend CoroutineScope.() -> Unit): Job {
        return scope.launch(errorHandler) {
            if (supervisor) {
                supervisorScope {
                    block.invoke(this)
                }
            } else {
                block.invoke(this)
            }
        }
    }

    private val errorHandler by lazy {
        CoroutineExceptionHandler { _, exception ->
            handleFailure?.invoke(Failure.CoroutineException(exception))
        }
    }
}