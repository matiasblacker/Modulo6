package com.example.individual5m6.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.individual5m6.model.Objeto

@Dao
interface ObjetoDao {

    @Query("SELECT * FROM objeto")
    suspend fun getAll(): List<Objeto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(objetos: List<Objeto>)
}