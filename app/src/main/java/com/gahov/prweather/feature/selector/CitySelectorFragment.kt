package com.gahov.prweather.feature.selector

import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import androidx.core.view.isVisible
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gahov.prweather.R
import com.gahov.prweather.arch.router.command.Command
import com.gahov.prweather.arch.ui.fragment.BaseFragment
import com.gahov.prweather.common.ui.AppBarOffsetChangeListener
import com.gahov.prweather.databinding.FragmentCitySelectorBinding
import com.gahov.prweather.feature.selector.adapter.CityListAdapter
import com.gahov.prweather.feature.selector.adapter.viewholder.CityViewHolder
import com.gahov.prweather.feature.selector.command.CitySelectorCommand
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CitySelectorFragment :
    BaseFragment<FragmentCitySelectorBinding, CitySelectorViewModel>(
        contentLayoutID = R.layout.fragment_city_selector,
        viewModelClass = CitySelectorViewModel::class.java
    ) {

    private val cityListAdapter: CityListAdapter by lazy {
        CityListAdapter(presenter = viewModel)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.presenter = viewModel

        setupScrollingAnimation()
        setupAdapter()
        setupSwipeToDeleteItemGesture()
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadAllCashedWeatherData()
    }

    override fun handleFeatureCommand(command: Command.FeatureCommand) {
        with(command) {
            if (this is CitySelectorCommand) {
                when (this) {
                    is CitySelectorCommand.DisplayContent -> displayContent(content)
                }
            } else {
                super.handleFeatureCommand(command)
            }
        }
    }

    private fun setupAdapter() {
        binding.citiesSelectorList.layoutManager = LinearLayoutManager(requireContext())
        binding.citiesSelectorList.adapter = cityListAdapter
    }

    private fun displayContent(content: List<CityModel>) {
        cityListAdapter.items = content
    }

    private fun setupScrollingAnimation() {
        with(binding) {
            citySelectorAppBarLayout.addOnOffsetChangedListener(object :
                AppBarOffsetChangeListener() {
                override fun onHide() {
                    hideViews()
                }

                override fun onShow() {
                    showViews()
                }
            })
        }
    }

    private fun hideViews() {
        binding.citiesSelectorToolbar.animate()
            .translationY((-binding.citiesSelectorToolbar.height).toFloat()).interpolator =
            AccelerateInterpolator(2F)
    }

    private fun showViews() {
        if (!binding.citiesSelectorToolbar.isVisible) {
            val valueInPixels = resources.getDimension(R.dimen.grid_56)
            binding.citiesSelectorToolbar.y = -valueInPixels
            binding.citiesSelectorToolbar.visibility = View.VISIBLE
        }
        binding.citiesSelectorToolbar.animate().translationY(0F).interpolator =
            DecelerateInterpolator(2F)
    }

    private fun setupSwipeToDeleteItemGesture() {
        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            override fun onMove(
                v: RecyclerView,
                h: RecyclerView.ViewHolder,
                t: RecyclerView.ViewHolder
            ) = false

            override fun onSwiped(h: RecyclerView.ViewHolder, dir: Int) {
                viewModel.deleteItem((h as CityViewHolder).item.cityName)
                cityListAdapter.removeAt(h.adapterPosition)
            }
        }).attachToRecyclerView(binding.citiesSelectorList)
    }
}