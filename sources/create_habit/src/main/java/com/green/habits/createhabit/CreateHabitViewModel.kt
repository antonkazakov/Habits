package com.green.habits.createhabit

import androidx.lifecycle.ViewModel
import com.green.coreapi.database.HabitsDao
import com.green.coreapi.dto.Habit
import javax.inject.Inject

class CreateHabitViewModel
@Inject constructor(
    private val habitsDao: HabitsDao
) : ViewModel() {

    suspend fun createHabit(habit: Habit) {
        habitsDao.createHabit(habit)
    }
}