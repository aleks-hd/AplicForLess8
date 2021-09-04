package com.hfad.aplicforless8.room

import androidx.room.*

@Dao
interface HistoryDao {
    @Query("SELECT * FROM HistoryEctity")
    fun all(): List<HistoryEctity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(entity: HistoryEctity)

    @Delete
    fun delete(ectity: HistoryEctity)
}