package com.green.habits.coreimpl

import androidx.room.Dao
import androidx.room.Query
import com.green.coreapi.database.HabitsContract
import com.green.coreapi.dto.Habit

@Dao
interface HabitsDao : HabitsContract {

    @Query("SELECT * FROM HABITS")
    override fun createHabit(): List<Habit>
}