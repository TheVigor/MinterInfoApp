package com.minter.info.app.core.data.remote.models.wallet

import com.google.gson.annotations.SerializedName

data class TotalDelegatedValue(
    @SerializedName("total_delegated_bip_value")
    val total: String
)