package com.hfad.aplicforless8.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hfad.aplicforless8.model.LocalRepository
import com.hfad.aplicforless8.model.RepositoryLocalIml
import com.hfad.aplicforless8.room.App.Companion.getHistoryDao

class DetailtViewModel(
    val historyLiveData: MutableLiveData<AppState> = MutableLiveData(),
    private val historyRepository: LocalRepository = RepositoryLocalIml(getHistoryDao())

) : ViewModel() {

     fun getLiveData() = historyLiveData



    fun getAllHistory() {
        historyLiveData.value = AppState.SuccessLocal(historyRepository.getAllHistory())
    }
}