package com.example.individual1m6

import androidx.lifecycle.LiveData

class TareaRepository(private val tareaDao: TareaDao) {
    val obtenerTareas: LiveData<List<Tarea>> = tareaDao.obtenerTareas()

    suspend fun insertar(tarea: Tarea) = tareaDao.insertar(tarea)
    suspend fun actualizar(tarea: Tarea) = tareaDao.actualizar(tarea)
    suspend fun borrar(tarea: Tarea) = tareaDao.borrar(tarea)
    fun obtenerTareaPorId(id: Int): LiveData<Tarea?> {
        return tareaDao.obtenerTareaPorId(id)
    }
}