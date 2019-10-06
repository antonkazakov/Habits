package com.green.habits.createhabit

import android.content.Context
import com.green.coreapi.mediator.CreateHabitMediator
import javax.inject.Inject

class CreateHabitMediatorImpl
@Inject constructor() : CreateHabitMediator {

    override fun openCreateHabitScreen(context: Context) {
        CreateHabitActivity.startCreateHabitActivity(context)
    }
}