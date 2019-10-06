package com.green.habits.createhabit

import com.green.coreapi.dto.Habit

interface CreateHabitRepository {

    fun createHabit(habit: Habit)
}