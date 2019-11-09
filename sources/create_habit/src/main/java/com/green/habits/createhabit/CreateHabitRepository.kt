package com.green.habits.createhabit

import com.green.coreapi.dto.Habit

interface CreateHabitRepository {

    suspend fun createHabit(habit: Habit)
}