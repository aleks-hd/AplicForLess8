package com.hfad.aplicforless8.model

import com.hfad.aplicforless8.repository.RemoteDataSource
import retrofit2.Callback


class RepositoryIml(private val remoteDataSource: RemoteDataSource) : Repository {
    override fun getFilmsFromServer(callback: Callback<Films>) {
        remoteDataSource.getFilmsAPI(callback)
    }

}