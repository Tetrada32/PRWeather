package com.gahov.prweather.data.test.base.file

import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.io.StringWriter

class FileReader {
    fun loadJsonAsString(fileName: String): String {
        val inputStream = javaClass.getResourceAsStream("/$fileName")
        return getStringFromInputStream(inputStream)
    }

    @Throws(IOException::class)
    private fun getStringFromInputStream(stream: InputStream?): String {
        var n = 0
        val buffer = CharArray(1024 * 4)
        val reader = InputStreamReader(stream, "UTF8")
        val writer = StringWriter()
        while (-1 != reader.read(buffer).also { n = it }) writer.write(buffer, 0, n)
        return writer.toString()
    }

    companion object {
        const val ERROR_UNAUTHORIZED_401_MOCK = "error/error_unauthorized_401.json"
        const val ERROR_401_MOCK = "error/error_city_not_found_404.json"
        const val SUCCESS_200_MOCK = "weather/weather_200.json"
    }
}