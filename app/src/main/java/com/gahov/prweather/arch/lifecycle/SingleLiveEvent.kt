package com.gahov.prweather.arch.lifecycle

import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

/**
 * A custom implementation of MutableLiveData that ensures that only the most recent observer
 * receives updates by suppressing repeated updates.
 *
 * @param T The type of data held by this MutableLiveData.
 */
class SingleLiveEvent<T> : MutableLiveData<T>() {

    private val pending = AtomicBoolean(false)

    /**
     * Observes the MutableLiveData and ensures that the observer is only notified of changes
     * if they are pending.
     *
     * @param owner The LifecycleOwner to which the observer should be attached.
     * @param observer The observer that will receive notifications of changes.
     */
    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        super.observe(owner) { t ->
            if (pending.compareAndSet(true, false)) {
                observer.onChanged(t)
            }
        }
    }

    /**
     * Sets a value on the MutableLiveData and marks it as pending.
     *
     * @param t The value to be set.
     */
    @MainThread
    override fun setValue(t: T?) {
        pending.set(true)
        super.setValue(t)
    }

    /**
     * Clears the value of the MutableLiveData by setting it to null.
     */
    @MainThread
    fun call() {
        value = null
    }

    /**
     * Posts a value on the MutableLiveData and marks it as pending.
     *
     * @param value The value to be posted.
     */
    override fun postValue(value: T?) {
        pending.set(true)
        super.postValue(value)
    }
}