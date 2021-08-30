package com.hfad.aplicforless8.model


data class Films(val results: List<ResulltFilm>?)


data class ResulltFilm(
   val id : Int?,
   val title : String?,
   val poster_path: String?,
   val overview:String?
)
