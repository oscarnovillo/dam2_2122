package com.example.roomviewmodel.data

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import java.time.LocalDate
import java.time.ZoneId


class Converters {
        @RequiresApi(Build.VERSION_CODES.O)
        @TypeConverter
        fun fromTimestamp(value: String?): LocalDate? {
            return value?.let { LocalDate.parse(it) }
        }

        @RequiresApi(Build.VERSION_CODES.O)
        @TypeConverter
        fun dateToTimestamp(date: LocalDate?): String? {
            val zoneId: ZoneId = ZoneId.systemDefault()
            return date?.toString()
        }
    }
