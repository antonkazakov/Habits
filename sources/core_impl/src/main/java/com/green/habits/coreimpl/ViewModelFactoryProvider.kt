package com.green.habits.coreimpl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactoryProvider
@Inject constructor(
    private val creators: @JvmSuppressWildcards MutableMap<Class<out ViewModel>, ViewModel>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val found = creators.entries.find {
            modelClass.isAssignableFrom(it.key)
        }
        val creator = found?.value
            ?: throw ClassNotFoundException("no model provided with for ${modelClass.simpleName}")
        return creator as T
    }
}