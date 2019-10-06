package com.green.coreapi.mediator

import android.content.Context

interface AppProvider {

    fun provideContext(): Context
}