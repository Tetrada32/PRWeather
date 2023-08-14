package com.gahov.prweather.data.mapper.weather.remote

import com.gahov.prweather.data.common.util.DateUtil.formatCurrentTimeWithOffset
import com.gahov.prweather.data.mapper.common.ApiMapper
import com.gahov.prweather.data.remote.entities.weather.WeatherDataResponse
import com.gahov.prweather.data.remote.entities.weather.WeatherResponse
import com.gahov.prweather.domain.entities.weather.WeatherEntity
import java.util.Locale


/**
 * A class providing mapping functions for converting to domain weather data from weather response.
 */

class WeatherResponseToDomainMapper : ApiMapper<WeatherDataResponse, WeatherEntity> {

    /**
     * Converts a weather API response model to the corresponding weather domain model.
     *
     * @param apiModel The weather API response model to be converted.
     * @return The resulting weather domain model [WeatherEntity].
     */
    override fun toDomain(apiModel: WeatherDataResponse): WeatherEntity {
        return WeatherEntity(
            id = apiModel.id,
            cityName = apiModel.name,
            countryName = apiModel.sys?.country,
            weatherDescription = capitalizeFirstLetter(getFirstWeatherItem(apiModel.weather).description),
            temperatureKelvin = apiModel.main?.temperature,
            humidity = apiModel.main?.humidity,
            windSpeed = apiModel.wind?.speed,
            iconId = getFirstWeatherItem(apiModel.weather).icon,
            time = formatCurrentTimeWithOffset(apiModel.timezone)
        )
    }

    /**
     * Retrieves the first weather item from a list of weather responses.
     * Application uses only this, first item.
     *
     * @param weatherList The list of weather responses.
     * @return The first [WeatherResponse] item from the list.
     * @throws Exception If the weather list is empty.
     */
    private fun getFirstWeatherItem(weatherList: List<WeatherResponse>?): WeatherResponse {
        if (!weatherList.isNullOrEmpty()) {
            return weatherList[0]
        } else {
            throw Exception()
        }
    }

    /**
     * Capitalizes the first letter of a string.
     * It is required for "weatherDescription" as it comes with lowercase first letter.
     *
     * @param input The input string to be capitalized.
     * @return The input string with the first letter capitalized.
     */
    private fun capitalizeFirstLetter(input: String?): String {
        if (input.isNullOrEmpty()) {
            return input.toString()
        }
        return input.replaceFirstChar {
            if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
        }
    }
}