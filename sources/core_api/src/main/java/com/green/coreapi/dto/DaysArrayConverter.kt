package com.green.coreapi.dto

import androidx.room.TypeConverter

class DaysArrayConverter {

    @TypeConverter
    fun daysToString(days: List<Int>): String {
        return days.joinToString(",")
    }

    @TypeConverter
    fun fromStringToDays(daysString: String): List<Int> {
        return daysString.split(",").map { it.toInt() }
    }
}