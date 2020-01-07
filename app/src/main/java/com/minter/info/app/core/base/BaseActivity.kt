package com.minter.info.app.core.base

import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.minter.info.app.core.data.local.WalletAddressRepository
import com.minter.info.app.core.extentions.activities.provideProgressDialog
import org.koin.android.ext.android.inject

abstract class BaseActivity: AppCompatActivity() {
    protected val progressDialog: AlertDialog by lazy { provideProgressDialog() }
    val walletAddressRepository: WalletAddressRepository by inject()
}