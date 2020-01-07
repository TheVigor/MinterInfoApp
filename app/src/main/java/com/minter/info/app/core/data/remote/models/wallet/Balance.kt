package com.minter.info.app.core.data.remote.models.wallet

import com.google.gson.annotations.SerializedName

data class Balance(
    @SerializedName("coin")
    val coin: String,
    @SerializedName("amount")
    val amount: Double
)