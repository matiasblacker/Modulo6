package com.example.individual2m6

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item_table")
data class Item(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nombre: String,
    val precioUnitario: Double,
    val cantidad: Int
)