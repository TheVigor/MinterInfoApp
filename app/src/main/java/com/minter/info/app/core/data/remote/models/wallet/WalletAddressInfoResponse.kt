package com.minter.info.app.core.data.remote.models.wallet

import com.google.gson.annotations.SerializedName
import com.minter.info.app.core.data.remote.models.wallet.WalletAddressInfo

data class WalletAddressInfoResponse(
    @SerializedName("data")
    val data: WalletAddressInfo
)