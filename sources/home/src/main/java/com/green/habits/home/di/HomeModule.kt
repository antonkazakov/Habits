package com.green.habits.home.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.green.coreapi.database.HabitsDao
import com.green.coreapi.mediator.CreateHabitMediator
import com.green.habits.home.viewmodel.HomeViewModel
import com.green.habits.home.repository.HabitsMemoryCache
import com.green.habits.home.repository.HabitsMemoryCacheImpl
import com.green.habits.home.viewmodel.HomeViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
interface HomeModule {

    @Binds
    @Singleton
    fun bindsCache(memoryCache: HabitsMemoryCacheImpl): HabitsMemoryCache

    @Binds
    fun bindsHomeViewModelFactory(homeViewModelFactory: HomeViewModelFactory): ViewModelProvider.Factory
}