package com.gahov.prweather.feature.selector.adapter.viewholder

import androidx.databinding.ViewDataBinding
import com.gahov.prweather.arch.ui.recycler.BaseViewHolder
import com.gahov.prweather.databinding.ItemCityBinding
import com.gahov.prweather.feature.selector.CityModel
import com.gahov.prweather.feature.selector.presenter.CitySelectorPresenter

class CityViewHolder(
    private val presenter: CitySelectorPresenter, binding: ViewDataBinding
) : BaseViewHolder<CityModel, ItemCityBinding>(binding) {

    override fun bindView(position: Int) {
        val city = item as CityModel.CityItem

        binding.presenter = presenter
        binding.city = city
    }
}