package com.gahov.prweather.arch.component.device

import android.os.Build
import com.gahov.prweather.domain.component.device.DeviceSystemInfo

/**
 * An abstract class that provides information about the Android system.
 * Extends the DeviceSystemInfo interface.
 *
 * Required to create "UserAgent" info.
 */
abstract class AndroidSystemInfo : DeviceSystemInfo {
    override val systemVersion: String = Build.VERSION.RELEASE
}