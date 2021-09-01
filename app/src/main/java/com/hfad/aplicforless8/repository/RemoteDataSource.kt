package com.hfad.aplicforless8.repository

import com.hfad.aplicforless8.model.Films
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RemoteDataSource {

    private val filmsAPI = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(
            GsonConverterFactory.create(

            )
        )
        .build().create(FilmAPI::class.java)

    fun getFilmsAPI (callback: Callback<Films>){
        filmsAPI.getListFilms("26c76063ddc0678e825b62a173a38f08","en-US","1")
            .enqueue(callback)

    }

}