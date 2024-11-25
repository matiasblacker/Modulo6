package com.example.sprintmodulo6.network

import com.example.sprintmodulo6.model.Phone
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface ApiService {

    // Endpoint para obtener la lista de teléfonos
    @GET("products")
    suspend fun getPhones(): List<Phone>

    // Endpoint para obtener el detalle de un teléfono específico
    @GET("details/{id}")
    suspend fun getPhoneDetails(@Path("id") phoneId: Int): Response<Phone>

    companion object {
        private const val BASE_URL = "https://my-json-server.typicode.com/Himuravidal/FakeAPIdata/"

        fun create(): ApiService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }
}