package com.example.sprintmodulo6

import junit.framework.TestCase.assertEquals
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PhoneDetailFragmentTest {

    private lateinit var mockWebServer: MockWebServer

    @Before
    fun setUp() {
        mockWebServer = MockWebServer()
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun TestRetrofitBaseUrl() {
        // Arrange: Se configura el MockWebServer para obtener una URL de prueba
        val expectedBaseUrl = mockWebServer.url("/").toString()

        // Act: Se crea una instancia de Retrofit con la URL esperada
        val retrofit = Retrofit.Builder()
            .baseUrl(expectedBaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // Assert: Se verifica que la URL base de Retrofit sea la misma que la URL del MockWebServer
        assertEquals(expectedBaseUrl, retrofit.baseUrl().toString())
    }
}