package com.minter.info.app.core.di

import com.minter.info.app.core.data.local.WalletAddressRepository
import org.koin.dsl.module

fun localModule() = module {
    single {
        WalletAddressRepository(get())
    }
}