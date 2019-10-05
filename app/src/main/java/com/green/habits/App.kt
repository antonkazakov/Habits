package com.green.habits

import android.app.Application
import com.green.core.mediator.ProvidersFacade
import com.green.core.mediator.AppFacade

class App : Application(), AppFacade {

    companion object {

        private var facadeComponent: FacadeComponent? = null

    }

    override fun getProvider(): ProvidersFacade {
        return facadeComponent ?: FacadeComponent.init(this).also {
            facadeComponent = it
        }
    }

    override fun onCreate() {
        super.onCreate()
        (getProvider() as FacadeComponent)
    }
}