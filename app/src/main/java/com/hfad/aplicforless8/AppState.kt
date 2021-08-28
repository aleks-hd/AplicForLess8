package com.hfad.aplicforless8

import com.hfad.aplicforless8.model.Films

sealed class AppState{
    data class Success (val listFilms: List<Films>?): AppState()
    data class Error(val error: Throwable) : AppState()
}
