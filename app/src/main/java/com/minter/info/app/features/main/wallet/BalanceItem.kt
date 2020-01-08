package com.minter.info.app.features.main.wallet

import com.minter.info.app.R
import com.minter.info.app.core.data.remote.models.wallet.Balance
import com.minter.info.app.core.extentions.round
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_balance.*

class BalanceItem (
    private val balance: Balance) : Item() {

    override fun getLayout() = R.layout.item_balance

    override fun bind(viewHolder: com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder, position: Int) {
        viewHolder.apply {

            tvBalanceAmount.text = balance.amount.round().toString()
            tvBalanceTitle.text = balance.coin
        }
    }
}