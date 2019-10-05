package com.green.coreapi.mediator

import android.app.Application

interface AppProvider {

    fun provideContext(): Application
}