package com.gahov.prweather.arch.ui.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gahov.prweather.arch.component.error.ErrorHandler
import com.gahov.prweather.arch.controller.BaseViewModel
import com.gahov.prweather.arch.ui.view.BaseView
import com.gahov.prweather.arch.ui.view.model.TextProvider
import com.gahov.prweather.common.ui.ktx.getString
import com.gahov.prweather.domain.component.logger.Logger
import com.gahov.prweather.domain.entities.failure.Failure
import javax.inject.Inject

abstract class BaseFragment<B : ViewDataBinding, T : ViewModel>(
    @LayoutRes private val contentLayoutID: Int,
    private val viewModelClass: Class<T>,
) : Fragment(), BaseView {

    protected lateinit var binding: B
        private set

    protected lateinit var viewModel: T

    @Inject
    protected open lateinit var logger: Logger

    @Inject
    protected open lateinit var failureHandler: ErrorHandler

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProvider(this, viewModelFactory)[viewModelClass]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, contentLayoutID, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        setBaseObservers()
        setObservers()
    }

    protected open fun setBaseObservers() {
        getCurrentViewModel()?.errorEvent?.observe(viewLifecycleOwner, ::displayError)
    }

    open fun logMessage(message: TextProvider.Text) {
        logger.log(
            message = message.text
        )
    }

    protected open fun setObservers() {}

    protected open fun getCurrentViewModel(): BaseViewModel? {
        return viewModel as? BaseViewModel
    }

    override fun displayError(failure: Failure) {
        failureHandler.parseFailure(failure)
    }

    override fun showMessage(textProvider: TextProvider) {
        context?.let { context ->
            Toast.makeText(
                context.applicationContext,
                textProvider.getString(context),
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}