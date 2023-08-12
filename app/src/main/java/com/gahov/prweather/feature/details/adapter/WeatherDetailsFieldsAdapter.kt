package com.gahov.prweather.feature.details.adapter

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.gahov.prweather.R
import com.gahov.prweather.arch.ui.recycler.BaseRecyclerListAdapter
import com.gahov.prweather.arch.ui.recycler.BaseViewHolder
import com.gahov.prweather.feature.details.adapter.viewholder.WeatherDetailsFieldViewHolder
import com.gahov.prweather.feature.details.entity.WeatherDetailsFieldModel

class WeatherDetailsFieldsAdapter(
) : BaseRecyclerListAdapter<WeatherDetailsFieldModel>(WeatherDetailsDiffUtil()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<WeatherDetailsFieldModel, out ViewDataBinding> {
        return WeatherDetailsFieldViewHolder(
            binding = inflate(parent, R.layout.item_weather_details_data)
        )
    }
}