package com.gahov.prweather.feature.selector.adapter

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.gahov.prweather.R
import com.gahov.prweather.arch.ui.recycler.BaseRecyclerListAdapter
import com.gahov.prweather.arch.ui.recycler.BaseViewHolder
import com.gahov.prweather.feature.selector.CityModel
import com.gahov.prweather.feature.selector.adapter.viewholder.CityViewHolder
import com.gahov.prweather.feature.selector.presenter.CitySelectorPresenter

class CityListAdapter(
    private val presenter: CitySelectorPresenter
) : BaseRecyclerListAdapter<CityModel>(CityListDiffUtil()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<CityModel, out ViewDataBinding> {
        return CityViewHolder(
            presenter = presenter,
            binding = inflate(parent, R.layout.item_city)
        )
    }
}