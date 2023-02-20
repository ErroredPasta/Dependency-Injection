package com.example.exchangerate.presentation

import android.app.Application
import com.example.exchangerate.di.koinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ConversionApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(applicationContext)
            modules(*koinModules)
        }
    }
}