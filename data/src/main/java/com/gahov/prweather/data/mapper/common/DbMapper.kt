package com.gahov.prweather.data.mapper.common

interface DbMapper<InputDomainModel, DbModel> {

    fun toDatabase(domainModel: InputDomainModel): DbModel

    fun toDomain(dbModel: DbModel): InputDomainModel
}