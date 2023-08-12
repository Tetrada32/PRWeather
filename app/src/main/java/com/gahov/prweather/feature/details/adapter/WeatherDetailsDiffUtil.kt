package com.gahov.prweather.feature.details.adapter

import androidx.recyclerview.widget.DiffUtil
import com.gahov.prweather.feature.details.entity.WeatherDetailsFieldModel

class WeatherDetailsDiffUtil : DiffUtil.ItemCallback<WeatherDetailsFieldModel>() {

    override fun areItemsTheSame(
        oldItem: WeatherDetailsFieldModel,
        newItem: WeatherDetailsFieldModel
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: WeatherDetailsFieldModel,
        newItem: WeatherDetailsFieldModel
    ): Boolean {
        return oldItem.value == newItem.value
    }
}