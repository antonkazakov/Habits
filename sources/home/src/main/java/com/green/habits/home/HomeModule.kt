package com.green.habits.home

import androidx.lifecycle.ViewModel
import com.green.coreapi.viewmodel.ViewModelKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class HomeModule {

    @Provides
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun provideLoginConfirmViewModel(viewModel: HomeViewModel): ViewModel = viewModel
}