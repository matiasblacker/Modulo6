package com.example.indiviv6.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.indiviv6.data.AppDatabase
import com.example.indiviv6.data.model.Item
import com.example.indiviv6.data.repository.ItemRepository
import kotlinx.coroutines.launch

class ItemViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ItemRepository
    val allItems: LiveData<List<Item>>
    val allFavorites: LiveData<List<Item>> // Observa los favoritos

    init {
        val itemDao = AppDatabase.getDatabase(application).itemDao()
        repository = ItemRepository(itemDao)
        allItems = repository.allItems
        allFavorites = repository.allFavorites // Obtiene favoritos del repositorio
    }

    fun insert(item: Item) = viewModelScope.launch {
        repository.insert(item)
    }

    fun delete(item: Item) = viewModelScope.launch {
        repository.delete(item)
    }
}
