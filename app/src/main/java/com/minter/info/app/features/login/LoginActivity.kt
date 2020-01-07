package com.minter.info.app.features.login

import android.os.Bundle
import com.minter.info.app.R
import com.minter.info.app.core.base.Result
import com.minter.info.app.core.base.BaseActivity
import com.minter.info.app.core.extentions.activities.goToMain
import com.minter.info.app.core.extentions.showToast
import kotlinx.android.synthetic.main.activity_login.*
import org.koin.android.viewmodel.ext.android.viewModel

class LoginActivity : BaseActivity() {

    private val loginViewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initViewModel()
        initViews()
    }

    private fun initViewModel() {
        loginViewModel.init(this,
            loading = {
                if (it) progressDialog.show() else progressDialog.dismiss()
            },
            error = {
                showToast(getString(R.string.error_check_inet_connection))
            },
            result = {
                when (it) {
                    is Result.Success -> goToMain()
                    is Result.Error -> showToast(it.error)
                }
            })
    }

    private fun initViews() {
        btnEnter.setOnClickListener {
            val walletAddress = etWalletAddress.text.trim()

            if (walletAddress.isBlank()) {
                showToast(getString(R.string.enter_wallet_address))
                return@setOnClickListener
            }
            loginViewModel.getWalletAddressInfo(walletAddress.toString())
        }
    }
}
