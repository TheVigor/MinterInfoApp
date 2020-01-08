package com.minter.info.app.core.data.remote.models.wallet

data class Wallet(
    val delegationInfo: WalletAddressDelegationResponse,
    val walletInfo: WalletAddressInfo
)