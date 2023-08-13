package com.gahov.prweather.feature.details

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.gahov.prweather.R
import com.gahov.prweather.arch.router.command.Command
import com.gahov.prweather.arch.ui.fragment.BaseFragment
import com.gahov.prweather.databinding.FragmentCityWeatherDetailsBinding
import com.gahov.prweather.feature.details.adapter.WeatherDetailsFieldsAdapter
import com.gahov.prweather.feature.details.command.CityWeatherDetailsCommand
import com.gahov.prweather.feature.details.entity.WeatherDetailsDataModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CityWeatherDetailsFragment :
    BaseFragment<FragmentCityWeatherDetailsBinding, CityWeatherDetailsViewModel>(
        contentLayoutID = R.layout.fragment_city_weather_details,
        viewModelClass = CityWeatherDetailsViewModel::class.java
    ) {

    private val args: CityWeatherDetailsFragmentArgs by navArgs()

    private val weatherDetailsFieldsAdapter: WeatherDetailsFieldsAdapter by lazy {
        WeatherDetailsFieldsAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        binding.presenter = viewModel
        viewModel.loadContent(args)
    }

    override fun handleFeatureCommand(command: Command.FeatureCommand) {
        with(command) {
            if (this is CityWeatherDetailsCommand) {
                when (this) {
                    is CityWeatherDetailsCommand.DisplayContent -> displayContent(content)
                    is CityWeatherDetailsCommand.OnError -> displayError(failure)
                }
            } else {
                super.handleFeatureCommand(command)
            }
        }
    }

    private fun setupAdapter() {
        binding.WeatherDetailsFieldList.layoutManager = LinearLayoutManager(requireContext())
        binding.WeatherDetailsFieldList.adapter = weatherDetailsFieldsAdapter
    }

    private fun displayContent(content: WeatherDetailsDataModel) {
        binding.model = content
        weatherDetailsFieldsAdapter.items = content.weatherFields ?: emptyList()
    }
}