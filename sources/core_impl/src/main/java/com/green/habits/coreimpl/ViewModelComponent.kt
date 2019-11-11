package com.green.habits.coreimpl

import com.green.coreapi.viewmodel.ViewModelsProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ViewModelModule::class])
interface ViewModelComponent : ViewModelsProvider