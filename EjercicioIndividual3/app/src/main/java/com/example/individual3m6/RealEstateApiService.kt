package com.example.individual3m6

import retrofit2.http.GET

interface RealEstateApiService {
    @GET("realestate")
    suspend fun getProperties(): List<RealEstate>
}