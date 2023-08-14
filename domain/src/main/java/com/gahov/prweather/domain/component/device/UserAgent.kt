package com.gahov.prweather.domain.component.device

/**
 * A class providing a user agent string based on device system information.
 *
 * @param deviceSystemInfo The [DeviceSystemInfo] implementation used to retrieve system version information.
 */
class UserAgent(deviceSystemInfo: DeviceSystemInfo) : UserAgentProvider {
    /**
     * The user agent string that represents the Android client and the device's OS version.
     */
    override val userAgent: String = String.format(
        PATTERN,
        deviceSystemInfo.systemVersion
    )

    /**
     * A companion object containing constant value, so a patterns for the user agent.
     */
    companion object {
        private const val PATTERN = "Android Client, OS version: %s"
    }
}