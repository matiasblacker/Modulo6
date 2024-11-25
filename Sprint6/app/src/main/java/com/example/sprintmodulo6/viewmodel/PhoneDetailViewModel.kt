package com.example.sprintmodulo6.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sprintmodulo6.model.Phone
import com.example.sprintmodulo6.repository.PhoneRepository
import kotlinx.coroutines.launch

class PhoneDetailViewModel : ViewModel() {
    private val repository = PhoneRepository()
    private val _phone = MutableLiveData<Phone>()
    val phone: LiveData<Phone> get() = _phone

    fun getPhoneDetails(phoneId: Int) {
        viewModelScope.launch {
            val phoneDetail = repository.getPhoneDetailsFromApi(phoneId)
            phoneDetail?.let {
                _phone.value = it
            }
        }
    }
}