package com.green.habits.core

import com.green.coreapi.database.DatabaseProvider
import com.green.coreapi.mediator.AppProvider
import com.green.coreapi.viewmodel.ViewModelsProvider
import com.green.habits.coreimpl.DaggerDatabaseComponent
import com.green.habits.coreimpl.DaggerViewModelComponent

object CoreProvidersFactory {

    fun createDatabaseBuilder(appProvider: AppProvider): DatabaseProvider {
        return DaggerDatabaseComponent.builder().appProvider(appProvider).build()
    }

    fun createViewModelBuilder(): ViewModelsProvider {
        return DaggerViewModelComponent.create()
    }
}