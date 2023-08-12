package com.gahov.prweather.feature.history.adapter

import androidx.recyclerview.widget.DiffUtil
import com.gahov.prweather.feature.details.entity.WeatherDetailsDataModel

class WeatherHistoryDiffUtil : DiffUtil.ItemCallback<WeatherDetailsDataModel>() {

    override fun areItemsTheSame(
        oldItem: WeatherDetailsDataModel,
        newItem: WeatherDetailsDataModel
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: WeatherDetailsDataModel,
        newItem: WeatherDetailsDataModel
    ): Boolean {
        return oldItem.weatherFields == newItem.weatherFields
    }
}