package com.hfad.aplicforless8

import com.hfad.aplicforless8.model.Films
import retrofit2.Callback

class RepositoryIml(private val remoteDataSource: RemoteDataSource) : Repository {
    override fun getFilmsFromServer(callback: Callback<List<Films>>) {
        remoteDataSource.getFilmsAPI(callback)
    }

}