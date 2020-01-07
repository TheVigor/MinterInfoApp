package com.minter.info.app.features.login

import android.content.Context
import com.minter.info.app.R
import com.minter.info.app.core.base.Result
import com.minter.info.app.core.base.BaseViewModel
import com.minter.info.app.core.data.local.WalletAddressRepository
import com.minter.info.app.core.data.remote.models.wallet.WalletAddressInfo

class LoginViewModel(
    private val context: Context,
    private val loginRepository: LoginRepository,
    private val walletAddressRepository: WalletAddressRepository
) : BaseViewModel<WalletAddressInfo, String>() {

    fun getWalletAddressInfo(walletAddress: String) {
        launchDataLoad {
            val response = loginRepository.getWalletAddressInfo(walletAddress)

            if (response.isSuccessful) {
                val body = response.body()

                walletAddressRepository.walletAddress = body?.data?.address ?: ""
                contentState.postValue(Result.Success(body!!.data))
            } else {
                contentState.postValue(Result.Error(context.getString(R.string.invalid_wallet_address)))
            }
        }
    }

}