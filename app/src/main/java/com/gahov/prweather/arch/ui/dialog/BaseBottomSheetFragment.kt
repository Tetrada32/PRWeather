package com.gahov.prweather.arch.ui.dialog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.gahov.prweather.arch.component.error.ErrorHandler
import com.gahov.prweather.arch.controller.BaseViewModel
import com.gahov.prweather.arch.provider.RouterProvider
import com.gahov.prweather.arch.router.NavComponentRouter
import com.gahov.prweather.arch.router.Router
import com.gahov.prweather.arch.router.command.Command
import com.gahov.prweather.arch.router.command.NavDirection
import com.gahov.prweather.arch.ui.view.BaseView
import com.gahov.prweather.arch.ui.view.model.TextProvider
import com.gahov.prweather.common.ui.ktx.getString
import com.gahov.prweather.domain.component.logger.Level
import com.gahov.prweather.domain.component.logger.Logger
import com.gahov.prweather.domain.entities.failure.Failure
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import javax.inject.Inject

/**
 * An abstract base class for creating BottomSheetDialogFragments that are integrated with ViewModel,
 * DataBinding, and navigation functionality.
 *
 * @param T The type of ViewModel associated with the fragment.
 * @param B The type of ViewDataBinding associated with the fragment.
 * @property layoutId The resource ID of the layout to be inflated.
 * @property viewModelClass The class of the associated ViewModel.
 */

abstract class BaseBottomSheetFragment<T : ViewModel, B : ViewDataBinding>(
    @LayoutRes private val layoutId: Int,
    private val viewModelClass: Class<T>
) : BottomSheetDialogFragment(), BaseView, RouterProvider {

    protected lateinit var binding: B
        private set

    protected lateinit var viewModel: T

    @Inject
    open lateinit var logger: Logger

    @Inject
    open lateinit var failureHandler: ErrorHandler

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    /**
     * The Router instance responsible for navigation within the fragment.
     */
    override val router: Router by lazy {
        NavComponentRouter(
            navController = findNavController(),
            logger = logger
        )
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        viewModel = ViewModelProvider(this, viewModelFactory)[viewModelClass]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        setBaseObservers()
        setObservers()
    }

    open fun logMessage(message: TextProvider.Text) {
        logger.log(
            message = message.text
        )
    }

    protected open fun navigate(command: Command) {
        when (command) {
            is NavDirection -> router.navigate(command)
            Command.Back -> router.popBackStack()
            Command.Root -> router.popToRoot()
            Command.Close -> requireActivity().finish()
            is Command.FeatureCommand -> navigateByFeature(command)
            is Command.Route -> commandError(command)
        }
    }

    protected open fun setBaseObservers() {
        getCurrentViewModel()?.let {
            it.errorEvent.observe(viewLifecycleOwner, ::displayError)
            it.command.observe(viewLifecycleOwner, ::handleCommandData)
            it.message.observe(viewLifecycleOwner, ::showMessage)
        }
    }

    protected open fun handleCommandData(command: Command) {
        when (command) {
            is NavDirection -> router.navigate(command)
            Command.Back -> router.popBackStack()
            Command.Root -> router.popToRoot()
            Command.Close -> requireActivity().finish()
            is Command.FeatureCommand -> handleFeatureCommand(command)
            is Command.Route -> commandError(command)
        }
    }

    protected open fun handleFeatureCommand(command: Command.FeatureCommand) {
        logger.log(
            level = Level.Warning, "method navigateByFeature isn't implement for $command"
        )
    }

    protected open fun navigateByFeature(command: Command.FeatureCommand) {
        logger.log(
            level = Level.Warning,
            message = "method navigateByFeature isn't implement for $command"
        )
    }

    private fun commandError(command: Command) {
        logger.log(
            level = Level.Warning,
            message = "navigation isn't implement for $command"
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