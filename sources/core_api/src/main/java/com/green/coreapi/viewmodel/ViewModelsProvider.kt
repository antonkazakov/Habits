package com.green.coreapi.viewmodel

import androidx.lifecycle.ViewModelProvider

interface ViewModelsProvider {

    fun provideViewModel(): ViewModelProvider.Factory
}