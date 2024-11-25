package com.example.individual2m6

import androidx.lifecycle.LiveData

class ItemRepository(private val itemDao: ItemDao) {
    val allItems: LiveData<List<Item>> = itemDao.getAllItems()

    suspend fun insert(item: Item) {
        itemDao.insert(item)
    }

    suspend fun deleteAll() {
        itemDao.deleteAll()
    }
}