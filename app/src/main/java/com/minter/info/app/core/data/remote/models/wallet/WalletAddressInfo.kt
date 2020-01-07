package com.minter.info.app.core.data.remote.models.wallet

import com.google.gson.annotations.SerializedName
import com.minter.info.app.core.data.remote.models.wallet.Balance

data class WalletAddressInfo(
    @SerializedName("address")
    val address: String,

    @SerializedName("balances")
    val balances: List<Balance>
)