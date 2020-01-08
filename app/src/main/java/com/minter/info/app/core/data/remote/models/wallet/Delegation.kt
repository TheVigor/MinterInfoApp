package com.minter.info.app.core.data.remote.models.wallet

import com.google.gson.annotations.SerializedName
import com.minter.info.app.core.data.remote.models.validators.ValidatorMeta

data class Delegation(
    @SerializedName("coin")
    val coin: String,

    @SerializedName("value")
    val value: Double,

    @SerializedName("bip_value")
    val bipValue: String,

    @SerializedName("pub_key")
    val pubKey: String,

    @SerializedName("validator_meta")
    val validatorMeta: ValidatorMeta
)