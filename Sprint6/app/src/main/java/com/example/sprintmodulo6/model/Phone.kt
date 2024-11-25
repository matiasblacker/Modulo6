package com.example.sprintmodulo6.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "phones")
data class Phone(
    @PrimaryKey val id: Int,
    val name: String,
    val price: Int,
    val image: String,
    val credit: Boolean
)