package com.example.exchangerate.di.activity

import com.example.exchangerate.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainActivityModule = module {
    viewModel { MainViewModel(get()) }
}