package com.example.nero.purse.database.history

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.ForeignKey.CASCADE
import android.arch.persistence.room.PrimaryKey
import com.example.nero.purse.database.purse.Purse

@Entity(
    tableName = "history", foreignKeys = [ForeignKey(
        entity = Purse::class, parentColumns = arrayOf("id"), childColumns = arrayOf("id"), onDelete = CASCADE
    )]
)
class HistoryPurse(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val idHistory: Int,
    @ColumnInfo(name = "purseId")
    val purseId: Int,
    @ColumnInfo(name = "date_operation")
    val dateOperatin: String,
    @ColumnInfo(name = "value")
    val valueHistory: Double
)