package com.minter.info.app.core.data.remote.models.validators

import com.google.gson.annotations.SerializedName

data class ValidatorsResponse(
    @SerializedName("data")
    val data: List<Validator>
)