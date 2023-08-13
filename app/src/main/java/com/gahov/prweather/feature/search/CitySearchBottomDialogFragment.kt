package com.gahov.prweather.feature.search

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment
import com.gahov.prweather.R
import com.gahov.prweather.arch.router.command.Command
import com.gahov.prweather.arch.ui.dialog.BaseBottomSheetFragment
import com.gahov.prweather.databinding.FragmentCitySearchBinding
import com.gahov.prweather.feature.search.command.CitySearchCommand
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CitySearchBottomDialogFragment :
    BaseBottomSheetFragment<CitySearchViewModel, FragmentCitySearchBinding>(
        layoutId = R.layout.fragment_city_search,
        viewModelClass = CitySearchViewModel::class.java
    ), TextWatcher {

    private val handler = Handler(Looper.getMainLooper())
    private var searchRunnable: Runnable? = null
    private var loadingRunnable: Runnable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.ThemeOverlay_Material3_BottomSheetDialog)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onLoading(false)
    }

    override fun setObservers() {
        super.setObservers()
        viewModel.isLoading.observe(viewLifecycleOwner, this::onLoading)
    }

    private fun onLoading(isLoading: Boolean) {
        binding.searchProgressBar.isVisible = isLoading
    }

    override fun handleFeatureCommand(command: Command.FeatureCommand) {
        with(command) {
            if (this is CitySearchCommand) {
                when (this) {
                    is CitySearchCommand.OnNetworkError -> displayError(failure)
                }
            } else {
                super.handleFeatureCommand(command)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        setInputListener()
    }

    private fun setInputListener() {
        binding.textInput.addTextChangedListener(this)
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        onLoading(false)
        searchRunnable?.let { handler.removeCallbacks(it) }
        loadingRunnable?.let { handler.removeCallbacks(it) }
    }

    override fun afterTextChanged(s: Editable?) {
        startLoadingAnimation()
        startSearching(s.toString())
    }

    private fun startLoadingAnimation() {
        loadingRunnable = Runnable {
            onLoading(true)
        }
        loadingRunnable?.let { handler.postDelayed(it, LOADING_DELAY) }
    }

    private fun startSearching(text: String) {
        searchRunnable = Runnable {
            viewModel.onNewCityName(text)
        }
        searchRunnable?.let { handler.postDelayed(it, SEARCHING_DELAY) }
    }

    private fun removeCallbacks() {
        searchRunnable?.let { handler.removeCallbacks(it) }
        loadingRunnable?.let { handler.removeCallbacks(it) }
    }

    override fun onPause() {
        super.onPause()
        removeCallbacks()
        binding.textInput.clearFocus()
        binding.textInput.removeTextChangedListener(this)
    }

    companion object {
        private const val LOADING_DELAY = 650L
        private const val SEARCHING_DELAY = 1500L
    }
}