package com.green.habits.coreimpl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ViewModelModule {

    @Provides
    @Singleton
    fun viewModelsHolder(): @JvmSuppressWildcards MutableMap<Class<out ViewModel>, ViewModel> {
        return mutableMapOf()
    }

    @Provides
    @Singleton
    fun bindsFactory(map: @JvmSuppressWildcards MutableMap<Class<out ViewModel>, ViewModel>): ViewModelProvider.Factory {
        return ViewModelFactoryProvider(map)
    }
}