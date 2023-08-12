package com.gahov.prweather.feature.selector.adapter

import androidx.recyclerview.widget.DiffUtil
import com.gahov.prweather.feature.selector.CityModel

class CityListDiffUtil : DiffUtil.ItemCallback<CityModel>() {

    override fun areItemsTheSame(oldItem: CityModel, newItem: CityModel): Boolean {
        return oldItem.areItemsSame(newItem)
    }

    override fun areContentsTheSame(oldItem: CityModel, newItem: CityModel): Boolean {
        return oldItem == newItem
    }
}