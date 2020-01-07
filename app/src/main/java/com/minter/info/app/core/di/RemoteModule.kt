package com.minter.info.app.core.di

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.minter.info.app.core.data.remote.MinterExplorerApi
import com.minter.info.app.features.login.LoginRepository
import com.minter.info.app.features.main.status.StatusRepository
import com.minter.info.app.features.main.validators.ValidatorsRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val ENTRY_POINT = "https://explorer-api.minter.network"

fun remoteModule() = module {

    single {
        createOkHttpClient()
    }

    single {
        createApi<MinterExplorerApi>(get())
    }

    single {
        LoginRepository(get())
    }

    single {
        ValidatorsRepository(get())
    }

    single {
        StatusRepository(get())
    }
}

fun createOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    return OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .build()
}


inline fun <reified T> createApi(okHttpClient: OkHttpClient): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(ENTRY_POINT)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().serializeNulls().create()))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
    return retrofit.create(T::class.java)
}