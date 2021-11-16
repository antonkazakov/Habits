package com.green.habits.home.di

import com.green.coreapi.mediator.ProvidersFacade
import com.green.habits.home.HomeFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [HomeModule::class],
    dependencies = [ProvidersFacade::class]
)
interface HomeComponent {

    companion object {

        fun create(providersFacade: ProvidersFacade): HomeComponent {
            return DaggerHomeComponent
                .builder()
                .providersFacade(providersFacade)
                .build()
        }
    }

    fun inject(homeFragment: HomeFragment)
}