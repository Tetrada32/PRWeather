package com.gahov.prweather.feature.search

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
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
    private var runnable: Runnable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.ThemeOverlay_Material3_BottomSheetDialog)
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
        runnable?.let { handler.removeCallbacks(it) }
    }

    override fun afterTextChanged(s: Editable?) {
        runnable = Runnable {
            val inputText = s.toString()
            viewModel.onNewCityName(inputText)
        }
        runnable?.let { handler.postDelayed(it, 1600) }
    }

    override fun onPause() {
        super.onPause()
        binding.textInput.clearFocus()
        binding.textInput.removeTextChangedListener(this)
    }
}