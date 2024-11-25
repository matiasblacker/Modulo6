package com.example.individual1m6

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TareaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(tarea: Tarea)

    @Update
    suspend fun actualizar(tarea: Tarea)

    @Delete
    suspend fun borrar(tarea: Tarea)

    @Query("SELECT * FROM tareas ORDER BY id ASC")
    fun obtenerTareas(): LiveData<List<Tarea>>

    @Query("SELECT * FROM tareas WHERE id = :id LIMIT 1")
    fun obtenerTareaPorId(id: Int): LiveData<Tarea?>
}