package com.minter.info.app.core.data.remote.models.validators

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Validator(
    @SerializedName("public_key")
    val publicKey: String,

    @SerializedName("status")
    val status: Int,

    @SerializedName("meta")
    val meta: ValidatorMeta,

    @SerializedName("stake")
    val stake: Double,

    @SerializedName("part")
    val part: Double?
) : Parcelable