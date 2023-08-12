package com.gahov.prweather.arch.ui.view

import com.gahov.prweather.arch.ui.view.model.TextProvider
import com.gahov.prweather.domain.entities.failure.Failure

interface BaseView {
    fun displayError(failure: Failure)

    fun showMessage(textProvider: TextProvider)
}