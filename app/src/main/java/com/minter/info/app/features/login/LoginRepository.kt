package com.minter.info.app.features.login

import com.minter.info.app.core.data.remote.models.wallet.WalletAddressInfoResponse
import com.minter.info.app.core.data.remote.MinterExplorerApi
import retrofit2.Response

class LoginRepository(private val api: MinterExplorerApi) {
    suspend fun getWalletAddressInfo(walletAddress: String): Response<WalletAddressInfoResponse> {
        return api.getWalletAddressInfo(walletAddress)
    }
}