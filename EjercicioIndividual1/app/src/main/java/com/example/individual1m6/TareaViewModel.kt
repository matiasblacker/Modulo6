package com.example.individual1m6

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TareaViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: TareaRepository
    val obtenerTareas: LiveData<List<Tarea>>

    init {
        val tareaDao = TareaDatabase.getDatabase(application).tareaDao()
        repository = TareaRepository(tareaDao)
        obtenerTareas = repository.obtenerTareas
    }

    fun insertar(tarea: Tarea) = viewModelScope.launch { repository.insertar(tarea) }
    fun actualizar(tarea: Tarea) = viewModelScope.launch { repository.actualizar(tarea) }
    fun borrar(tarea: Tarea) = viewModelScope.launch { repository.borrar(tarea) }

    // Método para obtener una tarea por ID
    fun obtenerTareaPorId(id: Int): LiveData<Tarea?> {
        return repository.obtenerTareaPorId(id)
    }
}