package com.gahov.prweather.feature.details.factory

import android.content.Context
import com.gahov.prweather.R
import com.gahov.prweather.arch.ui.view.model.IconProvider
import com.gahov.prweather.arch.ui.view.model.TextProvider
import com.gahov.prweather.domain.entities.weather.WeatherEntity
import com.gahov.prweather.feature.details.entity.WeatherDetailsDataModel
import com.gahov.prweather.feature.details.entity.WeatherDetailsFieldModel
import javax.inject.Inject


class WeatherEntityToModelBuilder @Inject constructor(private val context: Context) :
    WeatherEntityBuilder {

    private val descriptionField = context.getString(R.string.field_description)
    private val temperatureField = context.getString(R.string.field_temperature)
    private val humidityField = context.getString(R.string.field_humidity)
    private val windspeedField = context.getString(R.string.field_windspeed)

    private val weatherFields = listOf(
        descriptionField,
        temperatureField,
        humidityField,
        windspeedField
    )

    override fun buildWeatherModel(entityItem: WeatherEntity): WeatherDetailsDataModel {
        return WeatherDetailsDataModel(
            locationName = TextProvider.Text("${entityItem.cityName}, ${entityItem.countryName}"),
            weatherIcon = IconProvider.Url(createIconUrl(entityItem.iconId)),
            weatherFields = createWeatherDetailsList(entityItem),
            weatherDate = TextProvider.Text(createWeatherDateText(entityItem))
        )
    }

    private fun createWeatherDetailsList(weatherModel: WeatherEntity): List<WeatherDetailsFieldModel> {
        return weatherFields.map { field ->
            when (field) {
                descriptionField -> WeatherDetailsFieldModel(
                    TextProvider.Text(field),
                    TextProvider.Text(weatherModel.weatherDescription ?: EMPTY)
                )

                temperatureField -> WeatherDetailsFieldModel(
                    TextProvider.Text(field),
                    TextProvider.Text(kelvinToCelsius(weatherModel.temperatureKelvin).toString())
                )

                humidityField -> WeatherDetailsFieldModel(
                    TextProvider.Text(field),
                    TextProvider.Text(weatherModel.humidity?.toString() ?: EMPTY)
                )

                windspeedField -> WeatherDetailsFieldModel(
                    TextProvider.Text(field),
                    TextProvider.Text(weatherModel.windSpeed?.toString() ?: EMPTY)
                )

                else -> WeatherDetailsFieldModel()
            }
        }
    }

    private fun kelvinToCelsius(temp: Double?): Int? {
        return temp?.minus(KELVIN_DIFF)?.toInt()
    }

    private fun createWeatherDateText(entityItem: WeatherEntity): String {
        return context.getString(R.string.field_weather_date, entityItem.cityName, entityItem.time)
    }

    private fun createIconUrl(iconId: String?): String {
        return "$ICON_BASE_URL${iconId}$ICON_FORMAT"
    }

    companion object {
        const val ICON_BASE_URL = "http://openweathermap.org/img/w/"
        const val ICON_FORMAT = ".png"
        const val KELVIN_DIFF: Double = 273.15
        const val EMPTY = ""
    }
}