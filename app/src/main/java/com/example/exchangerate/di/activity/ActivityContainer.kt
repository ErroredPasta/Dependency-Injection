package com.example.exchangerate.di.activity

import androidx.lifecycle.ViewModelProvider
import com.example.exchangerate.di.app.AppContainer

class ActivityContainer(
    private val appContainer: AppContainer
) {

    val viewModelFactory: ViewModelProvider.Factory get() = appContainer.viewModelFactory

    interface Factory {
        fun create(): ActivityContainer
    }
}