package com.example.nero.purse.database.history

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

@Dao
interface HistoryPurseDAO {
    @Insert
    fun insertHistory(item: HistoryPurse)

    @Delete
    fun deleteHistory(item: HistoryPurse)

    @Update
    fun updateHistory(item: HistoryPurse)

    @Query("SELECT * FROM history WHERE purseId==:indexPurse")
    fun getHistoryByPurseId(indexPurse: Int): LiveData<List<HistoryPurse>>

    @Query("SELECT * FROM history")
    fun getAllHistory(): LiveData<List<HistoryPurse>>
}