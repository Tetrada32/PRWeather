package com.gahov.prweather.arch.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

/**
 * Factory class for creating instances of ViewModels using Dagger-provided creators.
 *
 * @param creators A map containing ViewModel classes and their corresponding Provider instances.
 */
class ViewModelFactory @Inject constructor(
    private val creators: @JvmSuppressWildcards Map<Class<out ViewModel>, Provider<ViewModel>>
) : ViewModelProvider.Factory {

    /**
     * Creates an instance of the requested ViewModel class.
     *
     * @param modelClass The class of the ViewModel to be created.
     * @return An instance of the requested ViewModel class.
     * @throws IllegalArgumentException if the ViewModel class is unknown.
     * @throws RuntimeException if there is an issue instantiating the ViewModel.
     */
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val creator = creators[modelClass] ?: creators.entries.firstOrNull {
            modelClass.isAssignableFrom(it.key)
        }?.value

        requireNotNull(creator) { "Unknown ViewModel class: $modelClass" }

        try {
            @Suppress("UNCHECKED_CAST")
            return creator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}