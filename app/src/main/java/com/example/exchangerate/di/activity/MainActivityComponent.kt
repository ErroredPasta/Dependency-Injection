package com.example.exchangerate.di.activity

import com.example.exchangerate.presentation.MainActivity
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = [MainActivityModule::class])
interface MainActivityComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance activity: MainActivity): MainActivityComponent
    }

    fun inject(activity: MainActivity)
}