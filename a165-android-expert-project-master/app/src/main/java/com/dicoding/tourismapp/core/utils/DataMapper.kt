package com.dicoding.tourismapp.core.utils

import com.dicoding.tourismapp.core.data.source.local.entity.TourismEntity
import com.dicoding.tourismapp.core.data.source.remote.response.TourismResponse
import com.dicoding.tourismapp.core.domain.model.Tourism

object DataMapper {
    fun mapResponsesToEntities(input: List<TourismResponse>): List<TourismEntity> {
        val tourismList = ArrayList<TourismEntity>()
        input.map {
            val tourism = TourismEntity(
                tourismId = it.id,
                description = it.description,
                name = it.name,
                address = it.address,
                latitude = it.latitude,
                longitude = it.longitude,
                like = it.like,
                image = it.image,
                isFavorite = false
            )
            tourismList.add(tourism)
        }
        return tourismList
    }

    fun mapEntitiesToDomain(input: List<TourismEntity>): List<Tourism> =
        input.map {
            Tourism(
                it.tourismId,
                it.name,
                it.description,
                it.address,
                it.latitude,
                it.longitude,
                it.like,
                it.image,
                it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Tourism) = TourismEntity(
        input.tourismId,
        input.name,
        input.description,
        input.address,
        input.latitude,
        input.longitude,
        input.like,
        input.image,
        input.isFavorite
    )
}