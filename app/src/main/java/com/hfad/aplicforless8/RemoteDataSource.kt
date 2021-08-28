package com.hfad.aplicforless8

import com.google.gson.GsonBuilder
import com.hfad.aplicforless8.model.Films
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RemoteDataSource {

    private val filmsAPI = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder().setLenient().create()
            )
        ).build().create(FilmAPI::class.java)

    fun getFilmsAPI (callback: Callback<List<Films>>){
        filmsAPI.getListFilms("en-US","1")
            .enqueue(callback)

    }

}