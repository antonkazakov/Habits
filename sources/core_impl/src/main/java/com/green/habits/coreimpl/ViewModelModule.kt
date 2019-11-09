package com.green.habits.coreimpl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.Multibinds

@Module
abstract class ViewModelModule {

    @Multibinds
    abstract fun viewModelsHolder(): Map<Class<out ViewModel>, ViewModel>

    @Binds
    abstract fun bindsFactory(
        viewModelFactory: ViewModelFactoryProvider
    ): ViewModelProvider.Factory
}