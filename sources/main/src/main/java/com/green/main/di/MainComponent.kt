package com.green.main.di

import com.green.coreapi.mediator.AppProvider
import com.green.coreapi.mediator.ProvidersFacade
import com.green.main.MainActivity
import dagger.Component

@Component(
    dependencies = [ProvidersFacade::class]
)
interface MainComponent {

    companion object {

        fun create(providersFacade: ProvidersFacade): MainComponent {
            return DaggerMainComponent.builder().providersFacade(providersFacade).build()
        }
    }

    fun inject(mainActivity: MainActivity)
}