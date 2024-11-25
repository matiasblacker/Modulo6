package com.example.sprintmodulo6.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sprintmodulo6.model.Phone
import com.example.sprintmodulo6.repository.PhoneRepository
import kotlinx.coroutines.launch

class PhoneViewModel : ViewModel() {
    private val repository = PhoneRepository()
    private val _phones = MutableLiveData<List<Phone>>()
    val phones: LiveData<List<Phone>> get() = _phones

    fun fetchPhones() {
        viewModelScope.launch {
            val phonesFromApi = repository.getPhonesFromApi()
            _phones.value = phonesFromApi
        }
    }
}