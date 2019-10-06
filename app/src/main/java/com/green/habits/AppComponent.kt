package com.green.habits

import android.app.Application
import android.content.Context
import com.green.coreapi.mediator.AppProvider
import dagger.Component
import dagger.BindsInstance


@Component(
    modules = [AppModule::class]
)
interface AppComponent : AppProvider {

    companion object {

        fun create(application: Application): AppProvider =
            DaggerAppComponent.builder().application(application.applicationContext).build()
    }

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(context: Context): Builder

        fun build(): AppComponent
    }
}