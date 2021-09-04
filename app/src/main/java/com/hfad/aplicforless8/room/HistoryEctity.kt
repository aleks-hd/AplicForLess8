package com.hfad.aplicforless8.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HistoryEctity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val title: String,
    val description: String,
    val urlImage: String,
    val abult: Boolean?
)
