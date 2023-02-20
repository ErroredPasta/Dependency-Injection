package com.example.exchangerate.di.app

import com.example.exchangerate.data.remote.ExchangeRateApi
import com.example.exchangerate.data.repository.ConversionRepositoryImpl
import com.example.exchangerate.domain.repository.ConversionRepository
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://v6.exchangerate-api.com/"

val appModule = module {
    factory { Dispatchers.IO }

    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ExchangeRateApi::class.java)
    }

    factory<ConversionRepository> { ConversionRepositoryImpl(get(), get()) }
}