package com.green.habits.coreimpl

import android.content.Context
import androidx.room.Room
import com.green.coreapi.database.HabitsDao
import com.green.coreapi.database.HabitsDatabaseContract
import dagger.Module
import dagger.Provides
import dagger.Reusable
import javax.inject.Singleton

private const val HABITS_DATABASE_NAME = "HABITS_DB"

@Module
class DatabaseModule {

    @Provides
    @Reusable
    fun provideHabitsDao(habitsDatabaseContract: HabitsDatabaseContract): HabitsDao {
        return habitsDatabaseContract.habitsDao()
    }

    @Provides
    @Singleton
    fun provideHabitsDatabase(context: Context): HabitsDatabaseContract {
        return Room.databaseBuilder(
            context,
            HabitsDatabase::class.java, HABITS_DATABASE_NAME
        ).build()
    }
}