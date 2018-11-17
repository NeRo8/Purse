package com.example.nero.purse.database.purse

import android.arch.lifecycle.LiveData
import android.support.annotation.WorkerThread

class PurseRepository(private val purseDao: PurseDAO) {
    val allPurse: LiveData<List<Purse>> = purseDao.getAllPurse()

    @WorkerThread
    suspend fun insert(purse: Purse) {
        purseDao.insertPurse(purse)
    }

    @WorkerThread
    suspend fun update(purse: Purse) {
        purseDao.updatePurse(purse)
    }

    @WorkerThread
    suspend fun delete(purse: Purse) {
        purseDao.deletePurse(purse)
    }

    @WorkerThread
    suspend fun getPurseById(purseId: Int): LiveData<List<Purse>> {
        return purseDao.getPurseById(purseId)
    }

}