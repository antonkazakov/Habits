package com.green.coreapi.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "HABITS")
data class Habit(
    @PrimaryKey
    val id: Long,
    val title: String,
    val description: String
)