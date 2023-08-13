package com.gahov.prweather.common.ui.ktx

import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter

@BindingAdapter("isVisible")
fun View.setVisibility(visibility: Boolean) {
    isVisible = visibility
}