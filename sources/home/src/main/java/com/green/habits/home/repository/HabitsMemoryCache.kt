package com.green.habits.home.repository

import com.green.coreapi.dto.Habit

interface HabitsMemoryCache {

    fun saveHabit(day: Int, habits: List<Habit>)

    fun getHabits(day: Int): List<Habit>

    fun clearCache()
}