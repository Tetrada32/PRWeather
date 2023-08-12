package com.gahov.prweather.arch.controller

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gahov.prweather.arch.coroutine.CoroutineLauncher
import com.gahov.prweather.arch.coroutine.impl.DefaultCoroutineLauncher
import com.gahov.prweather.arch.lifecycle.SingleLiveEvent
import com.gahov.prweather.arch.provider.CoroutineProvider
import com.gahov.prweather.domain.entities.failure.Failure
import kotlinx.coroutines.CoroutineScope

abstract class BaseViewModel : ViewModel(), Controller, CoroutineProvider {

    override val launcher: CoroutineLauncher by lazy {
        DefaultCoroutineLauncher(
            viewModelScope,
            ::handleFailure
        )
    }

    private val _errorEvent by lazy { SingleLiveEvent<Failure>() }
    val errorEvent: LiveData<Failure>
        get() = _errorEvent

    private val _isLoading by lazy { MutableLiveData(false) }
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    fun launch(block: suspend CoroutineScope.() -> Unit) = launcher.launch(block = block)


    override fun setLoading(boolean: Boolean) {
        _isLoading.value = boolean
    }

    override fun handleFailure(failure: Failure) {
        if (failure is Failure.FeatureFailure) {
            handleFailureFeature(failure)
        } else {
            _errorEvent.postValue(failure)
        }
    }

    protected open fun handleFailureFeature(failure: Failure.FeatureFailure) {
        _errorEvent.postValue(failure)
    }
}
