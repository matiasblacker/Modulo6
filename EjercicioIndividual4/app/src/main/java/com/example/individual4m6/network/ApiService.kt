package com.example.individual4m6.network

import com.example.individual4m6.model.Property
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("realestate")
    fun getProperties(): Call<List<Property>>

    companion object {
        private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"

        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}