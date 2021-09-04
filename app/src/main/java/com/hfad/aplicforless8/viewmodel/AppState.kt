package com.hfad.aplicforless8.viewmodel


import com.hfad.aplicforless8.model.Films
import com.hfad.aplicforless8.model.ResulltFilm


sealed class AppState{
    data class Success (val listFilms: Films?): AppState()
    data class SuccessLocal (val listFilm: List<ResulltFilm>):AppState()
    data class Error(val error: Throwable) : AppState()
}
