package com.green.habits.coreimpl

import com.green.coreapi.database.DatabaseProvider
import com.green.coreapi.mediator.AppProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [AppProvider::class],
    modules = [DatabaseModule::class]
)
interface DatabaseComponent : DatabaseProvider