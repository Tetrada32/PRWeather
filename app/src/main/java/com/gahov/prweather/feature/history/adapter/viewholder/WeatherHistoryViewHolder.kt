package com.gahov.prweather.feature.history.adapter.viewholder

import android.annotation.SuppressLint
import androidx.databinding.ViewDataBinding
import com.gahov.prweather.arch.ui.recycler.BaseViewHolder
import com.gahov.prweather.arch.ui.view.model.TextProvider
import com.gahov.prweather.databinding.ItemHistoryBinding
import com.gahov.prweather.feature.details.entity.WeatherDetailsDataModel
import com.gahov.prweather.feature.history.presenter.WeatherHistoryPresenter

class WeatherHistoryViewHolder(
    private val presenter: WeatherHistoryPresenter,
    binding: ViewDataBinding
) : BaseViewHolder<WeatherDetailsDataModel, ItemHistoryBinding>(binding) {

    @SuppressLint("SetTextI18n")
    override fun bindView(position: Int) {
        binding.itemWeatherHistoryMain.text = createWeatherDescription(item)
        binding.presenter = presenter
        binding.model = item
    }

    private fun createWeatherDescription(item: WeatherDetailsDataModel): String {
        val description = ((item.weatherFields?.get(0)?.value) as TextProvider.Text).text
        val temp = (item.mainTemperature as TextProvider.Text).text
        return "$description,  $temp"
    }
}