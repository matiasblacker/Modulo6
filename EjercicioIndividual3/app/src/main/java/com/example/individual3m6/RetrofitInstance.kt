package com.example.individual3m6

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"

    val api: RealEstateApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RealEstateApiService::class.java)
    }
}