package com.minter.info.app.core.data.remote.models.wallet

import com.google.gson.annotations.SerializedName

data class DelegationMeta(
    @SerializedName("additional")
    val additional: TotalDelegatedValue
)