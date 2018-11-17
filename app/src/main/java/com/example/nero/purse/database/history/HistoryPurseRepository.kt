package com.example.nero.purse.database.history

import android.arch.lifecycle.LiveData
import android.support.annotation.WorkerThread

class HistoryPurseRepository(private val historyDao: HistoryPurseDAO) {
    val allHistory: LiveData<List<HistoryPurse>> = historyDao.getAllHistory()

    @WorkerThread
    suspend fun insert(history: HistoryPurse) {
        historyDao.insertHistory(history)
    }

    @WorkerThread
    suspend fun update(history: HistoryPurse) {
        historyDao.updateHistory(history)
    }

    @WorkerThread
    suspend fun delete(history: HistoryPurse) {
        historyDao.deleteHistory(history)
    }

    @WorkerThread
    suspend fun getHistoryByPurseId(purseId: Int): LiveData<List<HistoryPurse>> {
        return historyDao.getHistoryByPurseId(purseId)
    }
}