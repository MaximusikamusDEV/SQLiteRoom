package com.example.tryingtousedatabases

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Insert
    fun insertitem(item:Items)

    @Query("SELECT * FROM InfoDb")
    fun getData(): Flow<List<Items>>
}