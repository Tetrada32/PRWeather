package com.gahov.prweather.data.source.weather.remote


import com.gahov.prweather.data.common.util.API_TOKEN
import com.gahov.prweather.data.local.entities.TokenData
import com.gahov.prweather.data.remote.call
import com.gahov.prweather.data.remote.configuration.interceptor.utils.token.TokenProvider
import com.gahov.prweather.data.remote.entities.weather.WeatherDataResponse
import com.gahov.prweather.data.remote.protocol.WeatherProtocol
import com.gahov.prweather.domain.entities.common.Either
import com.gahov.prweather.domain.entities.failure.Failure

class ImplWeatherRemoteSource(
    private val protocol: WeatherProtocol,
    private val tokenProvider: TokenProvider
) : WeatherRemoteSource {

    private var token = tokenProvider.getToken().takeIf { it?.isNotBlank() == true } ?: run {
        tokenProvider.setToken(TokenData(accessToken = API_TOKEN))
        API_TOKEN
    }

    override suspend fun loadCityWeatherByName(cityName: String): Either<Failure, WeatherDataResponse> {
        return call { protocol.getWeatherByCityName(cityName = cityName, accessToken = token) }
    }
}