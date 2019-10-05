package com.green.habits.coreimpl

import androidx.room.Database
import androidx.room.RoomDatabase
import com.green.coreapi.dto.Habit

@Database(entities = [Habit::class], version = 1)
abstract class HabitsDatabase : RoomDatabase() {

    abstract fun habitsDao(): HabitsDao
}