package com.example.indiviv6.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class Item(
    @PrimaryKey val id: Int,
    val name: String,
    val isFavorite: Boolean = false
)
