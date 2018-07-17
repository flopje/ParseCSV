package com.flowapps.parseCSV.persistence

import androidx.room.TypeConverter
import java.util.*

class DatabaseTypeConverters {

    companion object {
        @JvmStatic
        @TypeConverter
        fun fromTimeStamp(timeStamp: Long?) : Date? {
            return if (timeStamp == null) null else Date(timeStamp)
        }

        @JvmStatic
        @TypeConverter
        fun dateToTimeStamp(date: Date?) : Long? {
            return date?.time
        }

    }
}