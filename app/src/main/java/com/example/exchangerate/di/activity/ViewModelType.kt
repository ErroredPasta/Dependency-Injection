package com.example.exchangerate.di.activity

import androidx.lifecycle.ViewModel
import javax.inject.Qualifier
import kotlin.reflect.KClass

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ViewModelType(val klass: KClass<out ViewModel>)
