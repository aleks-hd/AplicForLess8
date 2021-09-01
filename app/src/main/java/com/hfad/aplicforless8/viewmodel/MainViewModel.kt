package com.hfad.aplicforless8.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.hfad.aplicforless8.repository.RemoteDataSource
import com.hfad.aplicforless8.model.RepositoryIml
import com.hfad.aplicforless8.model.Films
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(
    private val liveDataToObsrver: MutableLiveData<AppState> = MutableLiveData(),
    val repositoryIml: RepositoryIml = RepositoryIml(RemoteDataSource())
) {
    fun getLiveData() = liveDataToObsrver

    fun getDataFromServer() {

        repositoryIml.getFilmsFromServer(callback)

    }

    private val callback = object : Callback<Films> {
        override fun onResponse(call: Call<Films>,
                                response: Response<Films>) {

            val serverResponse: Films? = response.body()

            liveDataToObsrver.postValue(
                if (response.isSuccessful) {
                    checkResponse(serverResponse)
                } else {
                    AppState.Error(Throwable("ОШИБКА СО СТОРОНЫ СЕРВЕРА"))
                }
            )
        }

        override fun onFailure(call: Call<Films>, t: Throwable) {
            Log.e("ERROR", "FAIL FFFFFFFFFFFF")
        }
    }

    private fun checkResponse(serverResponse: Films?): AppState {
        val listResults = serverResponse
        return if (listResults == null) {
            AppState.Error(Throwable("ПУСТО"))
        } else {
            AppState.Success(serverResponse)
        }
    }

}


