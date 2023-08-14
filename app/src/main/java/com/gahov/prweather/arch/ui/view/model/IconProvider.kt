package com.gahov.prweather.arch.ui.view.model

import androidx.annotation.DrawableRes
import android.graphics.drawable.Drawable as AndroidDrawable

/**
 * A sealed class representing different ways to provide icons for various UI elements.
 */
sealed class IconProvider {
    data class ResIcon(@DrawableRes val icon: Int = 0) : IconProvider()
    data class ResVectorIcon(@DrawableRes val icon: Int = 0) : IconProvider()
    data class Url(val url: String = "") : IconProvider()
    data class Drawable(val icon: AndroidDrawable) : IconProvider()
}
