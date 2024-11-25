package com.example.indiviv6.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("breeds/list/all")
    suspend fun getBreeds(): Response<DogBreedsResponse>
}
