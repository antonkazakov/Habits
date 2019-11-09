package com.green.habits.createhabit

import androidx.lifecycle.ViewModel
import com.green.coreapi.dto.Habit
import javax.inject.Inject

class CreateHabitViewModel
@Inject constructor(
    private val createHabitRepository: CreateHabitRepository
) : ViewModel() {

    suspend fun createHabit(habit: Habit) {
        createHabitRepository.createHabit(habit)
    }
}