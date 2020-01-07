package com.minter.info.app.core.data.remote

import com.minter.info.app.core.data.remote.models.wallet.WalletAddressInfoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MinterExplorerApi {

    @GET("/api/v1/addresses/{wallet_address}")
    suspend fun getWalletAddressInfo(
        @Path("wallet_address") walletAddress: String): Response<WalletAddressInfoResponse>
}