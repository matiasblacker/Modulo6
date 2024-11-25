package com.example.individual3m6

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class RealEstateViewModel : ViewModel() {
    private val _properties = MutableLiveData<List<RealEstate>>()
    val properties: LiveData<List<RealEstate>> get() = _properties

    fun fetchProperties() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getProperties()
                _properties.value = response
            } catch (e: Exception) {
                // Manejo de errores
            }
        }
    }
}