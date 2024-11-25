package com.example.individual5m6.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.individual5m6.model.Objeto

@Database(entities = [Objeto::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun objetoDao(): ObjetoDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "objeto_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}