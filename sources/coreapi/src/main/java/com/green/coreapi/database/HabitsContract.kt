package com.green.coreapi.database

import com.green.coreapi.dto.Habit

interface HabitsContract {

    fun createHabit(): List<Habit>
}