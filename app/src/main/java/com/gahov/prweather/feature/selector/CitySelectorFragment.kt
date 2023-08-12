package com.gahov.prweather.feature.selector

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.gahov.prweather.R
import com.gahov.prweather.arch.ui.fragment.BaseFragment
import com.gahov.prweather.databinding.FragmentCitySelectorBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CitySelectorFragment :
    BaseFragment<FragmentCitySelectorBinding, CitySelectorViewModel>(
        contentLayoutID = R.layout.fragment_city_selector,
        viewModelClass = CitySelectorViewModel::class.java
    ) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.detailsButton.setOnClickListener { navigateToDetails() }
        binding.historyButton.setOnClickListener { navigateToHistory() }
    }

    private fun navigateToDetails() {
        val action = CitySelectorFragmentDirections.actionCitySelectorToCityDetails()
        findNavController().navigate(action)
    }

    private fun navigateToHistory() {
        val action = CitySelectorFragmentDirections.actionCitySelectorToCityHistory()
        findNavController().navigate(action)
    }
}