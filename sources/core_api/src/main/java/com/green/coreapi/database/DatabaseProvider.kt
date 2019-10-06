package com.green.coreapi.database

interface DatabaseProvider {

    fun provideDatabase(): HabitsDatabaseContract

    fun habitsDao(): HabitsDao
}