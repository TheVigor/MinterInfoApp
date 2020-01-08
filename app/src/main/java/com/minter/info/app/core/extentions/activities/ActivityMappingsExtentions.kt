package com.minter.info.app.core.extentions.activities

import android.app.Activity
import com.minter.info.app.core.data.remote.models.validators.Validator
import com.minter.info.app.core.data.remote.models.wallet.Balance
import com.minter.info.app.core.data.remote.models.wallet.Delegation
import com.minter.info.app.core.extentions.showToast
import com.minter.info.app.features.main.validators.ValidatorItem
import com.minter.info.app.features.main.wallet.BalanceItem
import com.minter.info.app.features.main.wallet.DelegationItem

fun Activity.mapToValidatorItems(validators: List<Validator>): List<ValidatorItem> {
    return validators.map {
        ValidatorItem(it) { validator ->
            goToValidatorDetail(validator)
        }
    }
}

fun Activity.mapToBalanceItems(balances: List<Balance>): List<BalanceItem> {
    return balances.map { BalanceItem(it) }
}

fun Activity.mapToDelegationItems(data: List<Delegation>): List<DelegationItem> {
    return data.map { DelegationItem(it) }
}