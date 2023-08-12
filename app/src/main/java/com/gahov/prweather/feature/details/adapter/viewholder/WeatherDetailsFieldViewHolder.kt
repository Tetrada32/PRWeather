package com.gahov.prweather.feature.details.adapter.viewholder

import androidx.databinding.ViewDataBinding
import com.gahov.prweather.arch.ui.recycler.BaseViewHolder
import com.gahov.prweather.databinding.ItemWeatherDetailsDataBinding
import com.gahov.prweather.feature.details.entity.WeatherDetailsFieldModel

class WeatherDetailsFieldViewHolder(
    binding: ViewDataBinding
) : BaseViewHolder<WeatherDetailsFieldModel, ItemWeatherDetailsDataBinding>(binding) {

    override fun bindView(position: Int) {
        binding.model = item
    }
}