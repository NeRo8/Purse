package com.example.nero.purse.database.history

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.example.nero.purse.database.PurseDatabase
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


class HistoryViewModel(application: Application) : AndroidViewModel(application) {
    private var parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Main
    private val scope = CoroutineScope(coroutineContext)

    private val repository: HistoryPurseRepository
    val allHistory: LiveData<List<HistoryPurse>>

    init {
        val historyDao = PurseDatabase.getDatabase(application).historyDao()
        repository = HistoryPurseRepository(historyDao)
        allHistory = repository.allHistory
    }

    fun insert(history: HistoryPurse) = scope.launch(Dispatchers.IO) {
        repository.insert(history)
    }


    fun update(history: HistoryPurse) = scope.launch(Dispatchers.IO) {
        repository.update(history)
    }

    fun delete(history: HistoryPurse) = scope.launch(Dispatchers.IO) {
        repository.delete(history)
    }

    fun getHistoryByPurseId(purseId: Int) = scope.launch(Dispatchers.IO) {
        repository.getHistoryByPurseId(purseId)
    }

    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }
}