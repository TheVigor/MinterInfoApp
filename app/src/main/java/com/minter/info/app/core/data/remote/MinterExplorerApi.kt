package com.minter.info.app.core.data.remote

import com.minter.info.app.core.data.remote.models.status.StatusInfoResponse
import com.minter.info.app.core.data.remote.models.validators.ValidatorsResponse
import com.minter.info.app.core.data.remote.models.wallet.WalletAddressDelegationResponse
import com.minter.info.app.core.data.remote.models.wallet.WalletAddressInfoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MinterExplorerApi {

    @GET("/api/v1/addresses/{wallet_address}")
    suspend fun getWalletAddressInfo(
        @Path("wallet_address") walletAddress: String): Response<WalletAddressInfoResponse>

    @GET("/api/v1/addresses/{wallet_address}/delegations")
    suspend fun getWalletAddressDelegations(
        @Path("wallet_address") walletAddress: String): Response<WalletAddressDelegationResponse>

    @GET("/api/v1/validators")
    suspend fun getValidators(): Response<ValidatorsResponse>

    @GET("/api/v1/status")
    suspend fun getStatusInfo(): Response<StatusInfoResponse>
}