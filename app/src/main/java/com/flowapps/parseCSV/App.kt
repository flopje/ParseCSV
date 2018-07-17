package com.flowapps.parseCSV

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.flowapps.parseCSV.persistence.database.AppDatabase


class App : Application() {

    init {
        instance = this
    }

    companion object {
        private lateinit var instance: App

        val db: AppDatabase by lazy {
            Room.databaseBuilder(applicationContext(),
                    AppDatabase::class.java, AppDatabase.NAME).build()
        }

        fun applicationContext(): Context {
            return instance.applicationContext
        }
    }
}