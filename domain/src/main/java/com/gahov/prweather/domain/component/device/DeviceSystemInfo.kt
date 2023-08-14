package com.gahov.prweather.domain.component.device

/**
 * An interface representing device system information.
 * Used to create a "User-Agent" header.
 *
 * See [UserAgent], [UserAgentProvider]
 */
interface DeviceSystemInfo {
    /**
     * The version of the device's operating system.
     */
    val systemVersion: String
}