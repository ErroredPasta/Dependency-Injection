package com.example.exchangerate.di.app

import com.example.exchangerate.data.repository.ConversionRepositoryImpl
import com.example.exchangerate.domain.repository.ConversionRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {

    @Binds
    fun bindConversionRepository(repositoryImpl: ConversionRepositoryImpl): ConversionRepository
}