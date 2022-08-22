package com.green.habits.createhabit

import android.content.Context
import com.otus.create_habit_api.CreateHabitMediator
import javax.inject.Inject

class CreateHabitMediatorImpl
@Inject constructor() : CreateHabitMediator {

    override fun openCreateHabitScreen(context: Context) {
        CreateHabitActivity.startCreateHabitActivity(context)
    }
}