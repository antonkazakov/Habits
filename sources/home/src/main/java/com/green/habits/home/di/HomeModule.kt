package com.green.habits.home.di

import androidx.lifecycle.ViewModel
import com.green.coreapi.database.HabitsDao
import com.green.coreapi.mediator.CreateHabitMediator
import com.green.habits.home.viewmodel.HomeViewModel
import com.green.habits.home.repository.HabitsMemoryCache
import com.green.habits.home.repository.HabitsMemoryCacheImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class HomeModule {

    @Binds
    @Singleton
    abstract fun bindsCache(memoryCache: HabitsMemoryCacheImpl): HabitsMemoryCache

    @Module
    companion object {

        @Provides
        @Singleton
        @JvmStatic
        fun provideHomeViewModel(
            map: @JvmSuppressWildcards MutableMap<Class<out ViewModel>, ViewModel>,
            habitsMemoryCache: HabitsMemoryCache,
            habitsDao: HabitsDao,
            createHabitMediator: CreateHabitMediator
        ): ViewModel = HomeViewModel(habitsMemoryCache, habitsDao, createHabitMediator).also {
            map[HomeViewModel::class.java] = it
        }

        @Provides
        @Singleton
        @JvmStatic
        fun provideDummy(viewModel: ViewModel) = EagerTrigger()
    }
}

class EagerTrigger