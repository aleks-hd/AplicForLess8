package com.hfad.aplicforless8

import com.hfad.aplicforless8.model.Films

interface Repository {
   fun getFilmsFromServer(callback: retrofit2.Callback<List<Films>>)
}