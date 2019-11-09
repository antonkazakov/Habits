package com.green.coreapi.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "COMPLETIONS")
data class Completion(
    @PrimaryKey
    val id: Int,
    val habitId: Int,
    val date:Long
)