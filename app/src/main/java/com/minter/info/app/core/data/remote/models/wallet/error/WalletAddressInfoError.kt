package com.minter.info.app.core.data.remote.models.wallet.error

import com.google.gson.annotations.SerializedName

data class WalletAddressInfoError(
    @SerializedName("code")
    val code: Int,
    @SerializedName("message")
    val message: String
)