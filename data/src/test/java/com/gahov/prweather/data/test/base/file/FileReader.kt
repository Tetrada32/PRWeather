package com.gahov.prweather.data.test.base.file

import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.io.StringWriter

/**
 * A utility class for reading JSON files and loading their content as strings.
 */
class FileReader {
    /**
     * Loads the content of a JSON file as a string.
     *
     * @param fileName The name of the JSON file to be loaded.
     * @return The content of the JSON file as a string.
     */
    fun loadJsonAsString(fileName: String): String {
        val inputStream = javaClass.getResourceAsStream("/$fileName")
        return getStringFromInputStream(inputStream)
    }

    /**
     * Converts an InputStream to a string.
     *
     * @param stream The input stream to be converted.
     * @return The converted string from the input stream.
     * @throws IOException If an I/O error occurs while reading the stream.
     */
    @Throws(IOException::class)
    private fun getStringFromInputStream(stream: InputStream?): String {
        var n = 0
        val buffer = CharArray(1024 * 4)
        val reader = InputStreamReader(stream, "UTF8")
        val writer = StringWriter()
        while (-1 != reader.read(buffer).also { n = it }) writer.write(buffer, 0, n)
        return writer.toString()
    }

    /**
     * Companion object containing constants for various mock JSON file names.
     */
    companion object {
        const val ERROR_UNAUTHORIZED_401_MOCK = "error/error_unauthorized_401.json"
        const val ERROR_CITY_NOT_FOUND_404_MOCK = "error/error_city_not_found_404.json"
        const val SUCCESS_200_MOCK = "weather/weather_200.json"
    }
}