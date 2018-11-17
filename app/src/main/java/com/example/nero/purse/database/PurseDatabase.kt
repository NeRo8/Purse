package com.example.nero.purse.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.nero.purse.database.history.HistoryPurse
import com.example.nero.purse.database.history.HistoryPurseDAO
import com.example.nero.purse.database.purse.PurseDAO
import com.example.nero.purse.database.purse.Purse

@Database(entities = [Purse::class, HistoryPurse::class], version = 2)
abstract class PurseDatabase : RoomDatabase() {
    abstract fun purseDao(): PurseDAO
    abstract fun historyDao(): HistoryPurseDAO

    companion object {
        @Volatile
        private var INSTANCE: PurseDatabase? = null

        fun getDatabase(context: Context): PurseDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PurseDatabase::class.java,
                    "PurseDatabase"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}