package com.sekiya9311.measureenvironment.repository.db

import androidx.room.TypeConverter
import java.util.*

class CalendarConverter {
    @TypeConverter
    fun fromLong(value: Long?): Calendar? {
        return value?.let {
            Calendar.getInstance()
                .apply {
                    clear()
                    timeInMillis = value
                }
        }
    }

    @TypeConverter
    fun fromDate(value: Calendar?): Long? {
        return value?.time?.time
    }
}
