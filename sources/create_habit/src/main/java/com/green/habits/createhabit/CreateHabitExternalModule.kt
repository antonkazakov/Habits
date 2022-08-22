package com.green.habits.createhabit

import com.otus.create_habit_api.CreateHabitMediator
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
interface CreateHabitExternalModule {

    @Binds
    @IntoMap
    @ClassKey(CreateHabitMediator::class)
    fun bindMediator(mediator: CreateHabitMediatorImpl): Any
}