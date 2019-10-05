package com.green.habits

import android.app.Application
import com.green.core.mediator.AppProvider
import com.green.core.mediator.ProvidersFacade
import dagger.Component

@Component(
    dependencies = [AppProvider::class],
    modules = [MediatorsBindings::class]
)
interface FacadeComponent : ProvidersFacade {

    companion object {

        fun init(application: Application): FacadeComponent =
            DaggerFacadeComponent.builder().appProvider(
                AppComponent.create(application)
            ).build()
    }

    fun inject(app: App)
}