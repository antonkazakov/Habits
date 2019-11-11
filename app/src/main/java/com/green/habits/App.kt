package com.green.habits

import android.app.Application
import com.green.coreapi.mediator.AppWithFacade
import com.green.coreapi.mediator.ProvidersFacade

class App : Application(), AppWithFacade {

    companion object {

        private var facadeComponent: FacadeComponent? = null
    }

    override fun getFacade(): ProvidersFacade {
        return facadeComponent ?: FacadeComponent.init(this).also {
            facadeComponent = it
        }
    }

    override fun onCreate() {
        super.onCreate()
        (getFacade() as FacadeComponent).inject(this)
    }
}