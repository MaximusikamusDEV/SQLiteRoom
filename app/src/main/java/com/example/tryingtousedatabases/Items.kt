package com.example.tryingtousedatabases

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "InfoDb")
data class Items (
    @PrimaryKey(autoGenerate = true)

    var id: Int? = null,

    @ColumnInfo(name = "Name")
    var name: String,

    @ColumnInfo(name = "Pass")
    var pass:String
)