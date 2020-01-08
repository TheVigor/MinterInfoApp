package com.minter.info.app.features.main.wallet

import com.minter.info.app.R
import com.minter.info.app.core.data.remote.models.wallet.Delegation
import com.minter.info.app.core.extentions.round
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_delegation.*

class DelegationItem (
    private val delegation: Delegation) : Item() {

    override fun getLayout() = R.layout.item_delegation

    override fun bind(viewHolder: com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder, position: Int) {
        viewHolder.apply {

            tvDelegationAmount.text = delegation.value.round().toString()
            tvDelegationCoin.text = delegation.coin

            val name = delegation.validatorMeta.name ?: ""
            tvValidator.text = if (name.length > 20) name.substring(0, 20) + "..." else name
        }
    }
}