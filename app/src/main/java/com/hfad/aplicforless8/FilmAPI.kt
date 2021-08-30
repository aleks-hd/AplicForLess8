package com.hfad.aplicforless8


import com.hfad.aplicforless8.model.Films

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface FilmAPI {
    @GET("movie/top_rated?")
    fun getListFilms(
        @Query("api_key") api: String,
        @Query("language") lang: String,
        @Query("page") str: String
    ): Call<Films>
}