package com.example.exchangerate.presentation

import android.app.Application
import com.example.exchangerate.di.app.AppContainer

class ConversionApplication : Application() {
    val appContainer: AppContainer by lazy {
        AppContainer()
    }
}