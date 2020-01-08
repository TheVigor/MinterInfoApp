package com.minter.info.app.core.di

import com.minter.info.app.features.login.LoginViewModel
import com.minter.info.app.features.main.status.StatusViewModel
import com.minter.info.app.features.main.validators.ValidatorsViewModel
import com.minter.info.app.features.main.wallet.WalletViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun viewModelModule() = module {

    viewModel {
        LoginViewModel(get(), get(), get())
    }

    viewModel {
        ValidatorsViewModel(get(), get())
    }

    viewModel {
        StatusViewModel(get(), get())
    }

    viewModel {
        WalletViewModel(get(), get())
    }
}