package com.gahov.prweather.data.mapper.common

interface ApiMapper<in InputApiModel, DomainModel> {

    fun toDomain(apiModel: InputApiModel): DomainModel
}