package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _texto = MutableLiveData<String>()
    val texto: LiveData<String> get() = _texto

    init {
        _texto.value = "Texto inicial en LiveData"
    }

    fun actualizarTexto(nuevoTexto: String) {
        _texto.value = nuevoTexto
    }
}
