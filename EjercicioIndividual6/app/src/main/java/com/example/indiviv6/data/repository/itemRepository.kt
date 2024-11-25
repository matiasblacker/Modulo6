package com.example.indiviv6.data.repository

import androidx.lifecycle.LiveData
import com.example.indiviv6.data.dao.ItemDao
import com.example.indiviv6.data.model.Item

class ItemRepository(private val itemDao: ItemDao) {
    val allItems: LiveData<List<Item>> = itemDao.getAll()

    suspend fun insert(item: Item) {
        itemDao.insert(item)
    }

    suspend fun delete(item: Item) {
        itemDao.delete(item)
    }
}
