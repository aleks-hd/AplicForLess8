package com.hfad.aplicforless8.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(HistoryEctity::class), version = 2, exportSchema = false)
abstract class HistoryDataBase:RoomDatabase() {
    abstract fun historyDao(): HistoryDao
}