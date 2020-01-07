package com.minter.info.app.core.data.remote.models.wallet.error

import com.google.gson.annotations.SerializedName

data class WalletAddressInfoErrorResponse(
    @SerializedName("error")
    val error: WalletAddressInfoError
)