package com.hfad.aplicforless8.model

import com.hfad.aplicforless8.model.Films

interface Repository {
   fun getFilmsFromServer(callback: retrofit2.Callback<Films>)
}