package com.green.coreapi.mediator

interface MediatorsProvider {

    fun provideMainMediator(): MainMediator

    fun provideHomeMediator(): HomeMediator

    fun provideCreateHabitMediator(): CreateHabitMediator
}