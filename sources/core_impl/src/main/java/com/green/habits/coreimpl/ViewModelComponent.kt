package com.green.habits.coreimpl

import androidx.lifecycle.ViewModelProvider
import com.green.coreapi.viewmodel.ViewModelsProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ViewModelModule::class])
interface ViewModelComponent : ViewModelsProvider {

    fun getViewModelFactory(): ViewModelProvider.Factory
}