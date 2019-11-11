package com.green.habits.home.di

import com.green.coreapi.mediator.ProvidersFacade
import com.green.coreapi.viewmodel.ViewModelsProvider
import com.green.habits.core.CoreProvidersFactory
import com.green.habits.home.HomeFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [HomeModule::class],
    dependencies = [ProvidersFacade::class, ViewModelsProvider::class]
)
interface HomeComponent : ViewModelsProvider {

    companion object {

        fun create(providersFacade: ProvidersFacade): HomeComponent {
            return DaggerHomeComponent
                .builder()
                .viewModelsProvider(CoreProvidersFactory.createViewModelBuilder())
                .providersFacade(providersFacade)
                .build()
        }
    }

    fun inject(homeFragment: HomeFragment)
}