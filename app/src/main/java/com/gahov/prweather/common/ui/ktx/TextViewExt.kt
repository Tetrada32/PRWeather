package com.gahov.prweather.common.ui.ktx

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.gahov.prweather.arch.ui.view.model.TextProvider

@BindingAdapter("setText")
fun TextView.setText(textProvider: TextProvider?) {
    textProvider?.let { text = textProvider.getString(context) }
}