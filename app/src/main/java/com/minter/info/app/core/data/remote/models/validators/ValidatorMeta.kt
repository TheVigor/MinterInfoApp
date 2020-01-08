package com.minter.info.app.core.data.remote.models.validators

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ValidatorMeta(
    @SerializedName("name")
    val name: String?,

    @SerializedName("description")
    val description: String?,

    @SerializedName("icon_url")
    val iconUrl: String?,

    @SerializedName("site_url")
    val siteUrl: String?
) : Parcelable