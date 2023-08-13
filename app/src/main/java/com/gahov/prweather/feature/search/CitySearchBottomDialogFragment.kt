package com.gahov.prweather.feature.search

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.gahov.prweather.R
import com.gahov.prweather.databinding.FragmentCitySearchBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CitySearchBottomDialogFragment : BottomSheetDialogFragment(), TextWatcher {

    private val handler = Handler(Looper.getMainLooper())
    private var runnable: Runnable? = null

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: CitySearchViewModel by viewModels { viewModelFactory }

    private lateinit var binding: FragmentCitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.ThemeOverlay_Material3_BottomSheetDialog)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_city_search, container, false)
        return binding.root
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
            viewModel.saveNewCityName(inputText)
        }
        runnable?.let { handler.postDelayed(it, 1600) }
    }

    override fun onPause() {
        super.onPause()
        binding.textInput.clearFocus()
        binding.textInput.removeTextChangedListener(this)
    }
}