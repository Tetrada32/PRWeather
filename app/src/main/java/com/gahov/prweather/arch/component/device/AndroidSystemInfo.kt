package com.gahov.prweather.arch.component.device

import android.os.Build
import com.gahov.prweather.domain.component.device.DeviceSystemInfo

abstract class AndroidSystemInfo : DeviceSystemInfo {
    override val systemVersion: String = Build.VERSION.RELEASE
}