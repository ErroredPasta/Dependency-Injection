package com.example.exchangerate.di.app

import androidx.lifecycle.ViewModelProvider
import com.example.exchangerate.data.remote.ExchangeRateApi
import com.example.exchangerate.data.repository.ConversionRepositoryImpl
import com.example.exchangerate.di.activity.ActivityContainer
import com.example.exchangerate.domain.repository.ConversionRepository
import com.example.exchangerate.presentation.MainViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Provider

class AppContainer {

    private val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build()
    }

    private val exchangeRateApi: ExchangeRateApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ExchangeRateApi::class.java)
    }

    private val ioDispatcher: CoroutineDispatcher get() = Dispatchers.IO

    private val conversionRepository: ConversionRepository
        get() = ConversionRepositoryImpl(
            api = exchangeRateApi,
            ioDispatcher = ioDispatcher
        )

    private val mainViewModelProvider: Provider<MainViewModel>
        get() = Provider { MainViewModel(repository = conversionRepository) }

    val viewModelFactory: ViewModelProvider.Factory
        get() = MainViewModel.Factory(provider = mainViewModelProvider)

    val activityContainerFactory = object : ActivityContainer.Factory {
        override fun create(): ActivityContainer =
            ActivityContainer(appContainer = this@AppContainer)
    }

    companion object {
        private const val BASE_URL = "https://v6.exchangerate-api.com/"
    }
}