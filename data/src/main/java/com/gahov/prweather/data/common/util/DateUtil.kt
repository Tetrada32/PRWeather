package com.gahov.prweather.data.common.util

import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

object DateUtil {
    private const val DEFAULT_DATE_FORMAT = "dd.MM.yyyy - HH:mm"

    fun formatCurrentTimeWithOffset(timezoneOffsetSeconds: Int?): String {
        return try {
            val time = LocalDateTime.now(timezoneOffsetSeconds?.let { ZoneOffset.ofTotalSeconds(it) })
            time.formatByPattern(DEFAULT_DATE_FORMAT)
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            val currentTime = LocalDateTime.now()
            currentTime.formatByPattern(DEFAULT_DATE_FORMAT)
        }
    }

    private fun LocalDateTime.formatByPattern(pattern: String): String {
        val formatter = DateTimeFormatter.ofPattern(pattern)
        return format(formatter)
    }
}
