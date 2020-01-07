package com.minter.info.app.core.data.local

import android.content.Context

class WalletAddressRepository(context: Context) {
    companion object {
        private const val STORAGE_FILENAME = "wallet_address_storage"
        private const val WALLET_ADDRESS = "wallet_address_token"
    }

    private val prefs = context.getSharedPreferences(STORAGE_FILENAME, Context.MODE_PRIVATE)

    var walletAddress: String
        get() = prefs.getString(WALLET_ADDRESS, "")!!
        set(value) = prefs.edit().putString(WALLET_ADDRESS, value).apply()
}