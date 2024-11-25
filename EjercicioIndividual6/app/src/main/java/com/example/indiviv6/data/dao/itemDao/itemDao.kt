package com.example.indiviv6.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ItemDao {
    @Query("SELECT * FROM items")
    fun getAll(): LiveData<List<Item>>

    @Query("SELECT * FROM items WHERE isFavorite = 1")
    fun getFavorites(): LiveData<List<Item>> // Nuevo método para obtener favoritos

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: Item)

    @Delete
    suspend fun delete(item: Item)
}
