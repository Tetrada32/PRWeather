package com.gahov.prweather.feature.history.adapter

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.gahov.prweather.R
import com.gahov.prweather.arch.ui.recycler.BaseRecyclerListAdapter
import com.gahov.prweather.arch.ui.recycler.BaseViewHolder
import com.gahov.prweather.feature.details.entity.WeatherDetailsDataModel
import com.gahov.prweather.feature.history.adapter.viewholder.WeatherHistoryViewHolder
import com.gahov.prweather.feature.history.presenter.WeatherHistoryPresenter

class WeatherHistoryAdapter(
    private val presenter: WeatherHistoryPresenter
) : BaseRecyclerListAdapter<WeatherDetailsDataModel>(WeatherHistoryDiffUtil()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<WeatherDetailsDataModel, out ViewDataBinding> {
        return WeatherHistoryViewHolder(
            binding = inflate(parent, R.layout.item_history),
            presenter = presenter
        )
    }
}