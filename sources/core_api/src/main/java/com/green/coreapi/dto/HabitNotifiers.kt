package com.green.coreapi.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "NOTIFIERS",
    foreignKeys = [ForeignKey(
        entity = Habit::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("habit_id")
    )]
)
data class HabitNotifiers(
    val id: Int,
    @ColumnInfo(name = "habit_id") val habitId: Int,
    val timestamp: Long
)