package com.green.core.mediator

import android.app.Application

interface AppProvider {

    fun provideContext(): Application
}