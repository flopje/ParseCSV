package com.flowapps.parseCSV.persistence.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.flowapps.parseCSV.persistence.AppDao
import com.flowapps.parseCSV.persistence.DatabaseTypeConverters
import com.flowapps.parseCSV.service.models.Person


@Database(entities = arrayOf(Person::class), version = AppDatabase.VERSION)
@TypeConverters(value = arrayOf(DatabaseTypeConverters::class))
abstract class AppDatabase : RoomDatabase() {

    abstract fun appDao(): AppDao

    companion object {
        const val NAME = "AppDatabase"
        const val VERSION = 1
    }
}