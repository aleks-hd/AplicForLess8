package com.hfad.aplicforless8.viewmodel


import com.hfad.aplicforless8.model.Films


sealed class AppState{
    data class Success (val listFilms: Films?): AppState()
    data class Error(val error: Throwable) : AppState()
}
