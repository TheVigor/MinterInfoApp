package com.minter.info.app

import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.transaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.minter.info.app.core.base.BaseActivity
import com.minter.info.app.core.extentions.activities.goToLogin
import com.minter.info.app.features.main.status.StatusFragment
import com.minter.info.app.features.main.validators.ValidatorsFragment
import com.minter.info.app.features.main.wallet.WalletFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    companion object {
        const val FRAGMENT_TAG = "fragment-tag"
        const val DEFAULT_FRAGMENT = R.id.item_wallet
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        checkWalletAddress()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initBottomNavigationView()
    }

    private fun checkWalletAddress() {
        if (walletAddressRepository.walletAddress.isNullOrEmpty()) {
            goToLogin()
        }
    }

    private fun initBottomNavigationView() {
        bottomNavigationView.setOnNavigationItemSelectedListener(this)
        bottomNavigationView.selectedItemId = DEFAULT_FRAGMENT
        navigate(DEFAULT_FRAGMENT)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        navigate(item.itemId)
        return true
    }

    private fun navigate(itemId: Int) {
        when (itemId) {
            R.id.item_wallet ->
                supportFragmentManager.transaction {
                    replace(container.id, WalletFragment.newInstance(), FRAGMENT_TAG)
                }
            R.id.item_validators ->
                supportFragmentManager.transaction {
                    replace(container.id, ValidatorsFragment.newInstance(), FRAGMENT_TAG)
                }
            R.id.item_status -> {
                supportFragmentManager.transaction {
                    replace(container.id, StatusFragment.newInstance(), FRAGMENT_TAG)
                }
            }
        }
    }
}
