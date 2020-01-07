package com.minter.info.app.core.data.remote.models.status

import com.google.gson.annotations.SerializedName

data class StatusInfo(
    @SerializedName("averageBlockTime")
    val averageBlockTime: Double,

    @SerializedName("bipPriceChange")
    val bipPriceChange: Double,

    @SerializedName("bipPriceUsd")
    val bipPriceUsd: Double,

    @SerializedName("latestBlockHeight")
    val latestBlockHeight: Int,

    @SerializedName("latestBlockTime")
    val latestBlockTime: String,

    @SerializedName("marketCap")
    val marketCap: Double,

    @SerializedName("totalTransactions")
    val totalTransactions: Int,

    @SerializedName("transactionsPerSecond")
    val transactionsPerSecond: Double
)