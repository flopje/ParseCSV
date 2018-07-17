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
        private var instance: App? = null
        var db: AppDatabase? = null

        fun applicationContext() : Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()

        db = Room.databaseBuilder(applicationContext,
                AppDatabase::class.java, AppDatabase.NAME).build()
    }
}