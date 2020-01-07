package com.minter.info.app.core.di

import com.minter.info.app.features.login.LoginViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun viewModelModule() = module {
    viewModel {
        LoginViewModel(get(), get(), get())
    }
}