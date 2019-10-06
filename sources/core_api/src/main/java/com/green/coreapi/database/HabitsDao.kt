package com.green.coreapi.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.green.coreapi.dto.Habit

@Dao
interface HabitsDao {

    @Query("SELECT * FROM HABITS")
    fun getHabits(): List<Habit>

    @Insert
    fun createHabit(habit: Habit)
}