package com.green.habits.home.repository

import com.green.coreapi.dto.Habit
import java.util.*
import javax.inject.Inject

class HabitsMemoryCacheImpl
@Inject constructor() : HabitsMemoryCache {

    private val storage = Collections.synchronizedMap(mutableMapOf<Int, List<Habit>>())

    override fun saveHabit(day: Int, habits: List<Habit>) {
        storage[day] = habits
    }

    override fun getHabits(day: Int): List<Habit> {
        return storage[day] ?: emptyList()
    }

    override fun clearCache() {
        storage.clear()
    }
}