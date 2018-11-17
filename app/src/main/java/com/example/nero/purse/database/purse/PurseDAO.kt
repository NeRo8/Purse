package com.example.nero.purse.database.purse

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

@Dao
interface PurseDAO {
    @Insert
    fun insertPurse(purse: Purse)

    @Delete
    fun deletePurse(purse: Purse)

    @Update
    fun updatePurse(purse: Purse)

    @Query("SELECT * FROM purse WHERE id=:purseId")
    fun getPurseById(purseId: Int): LiveData<List<Purse>>

    @Query("SELECT * FROM purse")
    fun getAllPurse(): LiveData<List<Purse>>
}