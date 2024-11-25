package com.example.individual5m6.repository

import com.example.individual5m6.data.ObjetoDao
import com.example.individual5m6.model.Objeto
import com.example.individual5m6.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ObjetoRepository(private val objetoDao: ObjetoDao, private val apiService: ApiService) {

    suspend fun getObjetos(): List<Objeto> {
        return withContext(Dispatchers.IO) {
            val objetosFromApi = apiService.getObjetos()
            objetoDao.insertAll(objetosFromApi)
            objetoDao.getAll()
        }
    }
}