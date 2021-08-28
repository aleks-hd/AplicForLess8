package com.hfad.aplicforless8


import com.hfad.aplicforless8.model.Films

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

import retrofit2.http.Query

//пока топорно
interface FilmAPI {

   @GET("movie/popular?api_key=26c76063ddc0678e825b62a173a38f08" )
    fun getListFilms(

     //  @Header("api_key") api:String,
     // @Query("api_key") lan:String,
       @Query("language") lang:String,
       @Query("page") str:String
    ): Call<List<Films>>
}