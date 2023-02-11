package com.example.exchangerate.di.activity

import androidx.lifecycle.ViewModelProvider
import com.example.exchangerate.presentation.MainActivity
import com.example.exchangerate.presentation.MainViewModel
import dagger.Module
import dagger.Provides

@Module
object MainActivityModule {

    @Provides
    fun provideMainViewModel(
        activity: MainActivity,
        viewModelFactory: ViewModelProvider.Factory
    ): MainViewModel = ViewModelProvider(activity, viewModelFactory)[MainViewModel::class.java]

}