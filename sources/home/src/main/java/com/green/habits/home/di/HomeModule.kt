package com.green.habits.home.di

import androidx.lifecycle.ViewModelProvider
import com.green.habits.home.repository.HabitsMemoryCache
import com.green.habits.home.repository.HabitsMemoryCacheImpl
import com.green.habits.home.viewmodel.HomeViewModelFactory
import com.otus.create_habit_api.CreateHabitMediator
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Provider
import javax.inject.Singleton

@Module
interface HomeModule {

    @Binds
    @Singleton
    fun bindsCache(memoryCache: HabitsMemoryCacheImpl): HabitsMemoryCache

    @Binds
    fun bindsHomeViewModelFactory(homeViewModelFactory: HomeViewModelFactory): ViewModelProvider.Factory

  companion object{

      @Provides
      fun provideMediator1(map: Map<Class<*>, @JvmSuppressWildcards Provider<Any>>): CreateHabitMediator {
          return map[CreateHabitMediator::class.java]!!.get() as CreateHabitMediator
      }
  }
}