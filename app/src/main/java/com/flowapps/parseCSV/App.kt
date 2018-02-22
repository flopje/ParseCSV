package com.flowapps.parseCSV

import android.app.Application
import android.content.Context
import com.raizlabs.android.dbflow.config.FlowManager


class App : Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: App? = null

        fun applicationContext() : Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        FlowManager.init(this)
    }
}