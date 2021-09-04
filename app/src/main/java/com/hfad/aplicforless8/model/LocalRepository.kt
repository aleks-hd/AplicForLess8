package com.hfad.aplicforless8.model

interface LocalRepository{
    fun getAllHistory(): List<ResulltFilm>
    fun saveEntity(film : ResulltFilm)
}