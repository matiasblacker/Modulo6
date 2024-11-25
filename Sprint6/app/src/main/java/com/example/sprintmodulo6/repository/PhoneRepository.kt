package com.example.sprintmodulo6.repository

import com.example.sprintmodulo6.model.Phone
import com.example.sprintmodulo6.network.ApiService

class PhoneRepository {
    private val apiService = ApiService.create()

    suspend fun getPhonesFromApi(): List<Phone> {
        return apiService.getPhones()
    }

    suspend fun getPhoneDetailsFromApi(phoneId: Int): Phone? {
        return apiService.getPhoneDetails(phoneId).body()
    }
}