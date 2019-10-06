package com.green.habits.home

import com.green.coreapi.mediator.ProvidersFacade
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [ProvidersFacade::class]
)
interface HomeComponent {


    companion object {

        fun create(providersFacade: ProvidersFacade): HomeComponent {
            return DaggerHomeComponent.builder().providersFacade(providersFacade).build()
        }
    }

    fun inject(homeFragment: HomeFragment)
}