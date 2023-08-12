package com.gahov.prweather.arch.provider

import com.gahov.prweather.arch.coroutine.CoroutineLauncher

interface CoroutineProvider {
    val launcher: CoroutineLauncher
}