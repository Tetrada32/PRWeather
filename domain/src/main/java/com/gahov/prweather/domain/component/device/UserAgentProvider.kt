package com.gahov.prweather.domain.component.device

/**
 * An interface for providing a user agent string.
 */
interface UserAgentProvider {
    /**
     * The user agent string that represents the client or device.
     */
    val userAgent: String
}