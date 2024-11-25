package com.example.individual5m6.network

import com.example.individual5m6.model.Objeto
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("realestate")
    suspend fun getObjetos(): List<Objeto>

    companion object {
        private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"

        fun create(): ApiService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }
}