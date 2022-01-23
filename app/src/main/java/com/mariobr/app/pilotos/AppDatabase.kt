package com.mariobr.app.pilotos

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Piloto::class], version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun pilotoDao(): PilotoDao
}