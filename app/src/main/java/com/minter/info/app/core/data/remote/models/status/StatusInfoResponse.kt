package com.minter.info.app.core.data.remote.models.status

import com.google.gson.annotations.SerializedName

data class StatusInfoResponse(
    @SerializedName("data")
    val data: StatusInfo
)