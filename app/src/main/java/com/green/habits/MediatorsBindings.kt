package com.green.habits

import com.green.coreapi.mediator.CreateHabitMediator
import com.green.coreapi.mediator.HomeMediator
import com.green.coreapi.mediator.MainMediator
import com.green.habits.createhabit.CreateHabitMediatorImpl
import com.green.habits.home.HomeMediatorImpl
import com.green.main.navigation.MainMediatorImpl
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
interface MediatorsBindings {

    @Binds
    @Reusable
    fun bindsHabitsMediator(createHabitMediatorImpl: CreateHabitMediatorImpl): CreateHabitMediator

    @Binds
    @Reusable
    fun bindsMainMediator(mainMediatorImpl: MainMediatorImpl): MainMediator

    @Binds
    @Reusable
    fun bindsHomeMediator(homeMediatorImpl: HomeMediatorImpl): HomeMediator
}