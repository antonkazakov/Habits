package com.green.habits.core

import com.green.coreapi.database.DatabaseProvider
import com.green.coreapi.mediator.AppProvider
import com.green.habits.coreimpl.DaggerDatabaseComponent

object CoreProvidersFactory {

    fun createDatabaseBuilder(appProvider: AppProvider): DatabaseProvider {
        return DaggerDatabaseComponent.builder().appProvider(appProvider).build()
    }
}