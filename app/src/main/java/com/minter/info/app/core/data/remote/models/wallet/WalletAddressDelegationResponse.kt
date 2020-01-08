package com.minter.info.app.core.data.remote.models.wallet

import com.google.gson.annotations.SerializedName

data class WalletAddressDelegationResponse(
    @SerializedName("data")
    val data: List<Delegation>,

    @SerializedName("meta")
    val meta: DelegationMeta
)