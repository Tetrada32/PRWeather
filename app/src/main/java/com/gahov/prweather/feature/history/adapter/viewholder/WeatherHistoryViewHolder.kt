package com.gahov.prweather.feature.history.adapter.viewholder

import androidx.databinding.ViewDataBinding
import com.gahov.prweather.arch.ui.recycler.BaseViewHolder
import com.gahov.prweather.databinding.ItemHistoryBinding
import com.gahov.prweather.feature.details.entity.WeatherDetailsDataModel
import com.gahov.prweather.feature.history.presenter.WeatherHistoryPresenter

class WeatherHistoryViewHolder(
    private val presenter: WeatherHistoryPresenter,
    binding: ViewDataBinding
) : BaseViewHolder<WeatherDetailsDataModel, ItemHistoryBinding>(binding) {

    override fun bindView(position: Int) {
        binding.presenter = presenter
        binding.model = item
    }
}