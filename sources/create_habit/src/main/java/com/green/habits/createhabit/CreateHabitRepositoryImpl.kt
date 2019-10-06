package com.green.habits.createhabit

import com.green.coreapi.database.HabitsDao
import com.green.coreapi.dto.Habit
import javax.inject.Inject

class CreateHabitRepositoryImpl
@Inject constructor(
    private val habitsDao: HabitsDao
) : CreateHabitRepository {

    override fun createHabit(habit: Habit) {
        habitsDao.createHabit(habit)
    }
}