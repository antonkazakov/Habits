package com.green.habits

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Module
    companion object {

        private const val PREFS_NAME = "HABITS_SP"

        @JvmStatic
        @Provides
        @Singleton
        fun provideSharedPreferences(application: Application) =
            application.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }
}