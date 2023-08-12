package com.gahov.prweather.feature.history

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.gahov.prweather.R
import com.gahov.prweather.arch.router.command.Command
import com.gahov.prweather.arch.ui.fragment.BaseFragment
import com.gahov.prweather.databinding.FragmentCityHistoryBinding
import com.gahov.prweather.feature.details.entity.WeatherDetailsDataModel
import com.gahov.prweather.feature.history.adapter.WeatherHistoryAdapter
import com.gahov.prweather.feature.history.command.WeatherHistoryCommand
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeatherHistoryFragment :
    BaseFragment<FragmentCityHistoryBinding, WeatherHistoryViewModel>(
        contentLayoutID = R.layout.fragment_city_history,
        viewModelClass = WeatherHistoryViewModel::class.java
    ) {

    private val weatherHistoryAdapter: WeatherHistoryAdapter by lazy {
        WeatherHistoryAdapter(presenter = viewModel)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.mockContent()
        binding.presenter = viewModel
        setupAdapter()
    }

    override fun handleFeatureCommand(command: Command.FeatureCommand) {
        with(command) {
            if (this is WeatherHistoryCommand) {
                when (this) {
                    is WeatherHistoryCommand.DisplayContent -> displayContent(content)
                }
            } else {
                super.handleFeatureCommand(command)
            }
        }
    }

    private fun setupAdapter() {
        binding.historyList.layoutManager = LinearLayoutManager(requireContext())
        binding.historyList.adapter = weatherHistoryAdapter
    }

    private fun displayContent(content: List<WeatherDetailsDataModel>) {
        weatherHistoryAdapter.items = content
    }
}