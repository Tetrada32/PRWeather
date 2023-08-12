package com.gahov.prweather.arch.controller

import com.gahov.prweather.arch.router.command.Command
import com.gahov.prweather.arch.ui.view.model.TextProvider
import com.gahov.prweather.domain.entities.failure.Failure

interface Controller {

    fun showMessage(message: TextProvider)

    fun setLoading(boolean: Boolean)

    fun navigate(command: Command)

    fun handleFailure(failure: Failure)

}