package com.minter.info.app.features.main.wallet

import android.content.Context
import com.minter.info.app.R
import com.minter.info.app.core.base.BaseViewModel
import com.minter.info.app.core.base.Result
import com.minter.info.app.core.data.remote.models.wallet.Wallet
import com.minter.info.app.core.data.remote.models.wallet.WalletAddressInfo
import com.minter.info.app.features.login.LoginRepository

class WalletViewModel(
    private val context: Context,
    private val loginRepository: LoginRepository
) : BaseViewModel<Wallet, String>() {

    fun getWalletAddressInfo(walletAddress: String) {
        launchDataLoad {
            val response = loginRepository.getWalletAddressInfo(walletAddress)

            if (response.isSuccessful) {
                val body = response.body()

                val delegations = loginRepository.getWalletAddressDelegations(walletAddress)

                if (delegations.isSuccessful) {
                    contentState.postValue(Result.Success(
                        Wallet(
                            delegations.body()!!,
                            body!!.data
                        )
                    ))
                } else {
                    contentState.postValue(Result.Error(context.getString(R.string.error_receiving_wallet_info)))
                }
            } else {
                contentState.postValue(Result.Error(context.getString(R.string.error_receiving_wallet_info)))
            }
        }
    }

}