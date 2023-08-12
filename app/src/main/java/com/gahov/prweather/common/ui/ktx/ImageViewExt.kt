package com.gahov.prweather.common.ui.ktx

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.gahov.prweather.arch.ui.view.model.IconProvider

@BindingAdapter("setImage")
fun ImageView.setImage(iconProvider: IconProvider?) {
    when (iconProvider) {
        is IconProvider.Drawable -> loadImage(iconProvider.icon)
        is IconProvider.Url -> loadImage(iconProvider.url)
        is IconProvider.ResIcon -> loadImage(iconProvider.icon)
        is IconProvider.ResVectorIcon -> loadImage(iconProvider.icon)
        else -> setImageDrawable(null)
    }
}