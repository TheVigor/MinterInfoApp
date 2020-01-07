package com.minter.info.app

import android.os.Bundle
import com.minter.info.app.core.base.BaseActivity
import com.minter.info.app.core.extentions.activities.goToLogin

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        checkWalletAddress()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun checkWalletAddress() {
        if (walletAddressRepository.walletAddress.isNullOrEmpty()) {
            goToLogin()
        }
    }
}
