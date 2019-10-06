package com.green.habits.createhabit

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [CreateHabitModule::class])
interface CreateHabitComponent {

    fun inject(createHabitActivity: CreateHabitActivity)
}