package com.example.nero.purse.database.purse

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "purse", indices = [Index(value = ["name"], unique = true)])
data class Purse(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var purseId: Int? = null,
    @ColumnInfo(name = "name")
    val purseName: String?,
    @ColumnInfo(name = "value")
    val purseValue: Double?,
    @ColumnInfo(name = "type")
    val purseType: String?
) : Parcelable
