package com.example.individual5m6.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Objeto(
    @PrimaryKey val id: Long,
    val title: String,
    val imageUrl: String,
    val description: String
)