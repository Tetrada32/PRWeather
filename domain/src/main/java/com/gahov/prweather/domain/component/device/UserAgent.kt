package com.gahov.prweather.domain.component.device

class UserAgent(deviceSystemInfo: DeviceSystemInfo) : UserAgentProvider {
    override val userAgent: String = String.format(
        PATTERN,
        deviceSystemInfo.systemVersion
    )

    companion object {
        private const val PATTERN = "Android Client, OS version: %s"
    }
}