package com.minter.info.app.features.main.wallet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.minter.info.app.R
import com.minter.info.app.core.base.BaseActivity
import com.minter.info.app.core.base.Result
import com.minter.info.app.core.data.remote.models.wallet.Wallet
import com.minter.info.app.core.extentions.activities.mapToBalanceItems
import com.minter.info.app.core.extentions.activities.mapToDelegationItems
import com.minter.info.app.core.extentions.gone
import com.minter.info.app.core.extentions.showToast
import com.minter.info.app.core.extentions.visible
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_wallet.*
import org.koin.android.viewmodel.ext.android.viewModel


class WalletFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = WalletFragment()
    }

    private val walletViewModel: WalletViewModel by viewModel()

    private val coinsAdapter = GroupAdapter<GroupieViewHolder>()
    private val delegatedAdapter = GroupAdapter<GroupieViewHolder>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wallet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvMyCoins.adapter = coinsAdapter
        rvDelegatedCoins.adapter = delegatedAdapter

        initViewModel()

        walletViewModel.getWalletAddressInfo(
            (requireActivity() as BaseActivity).walletAddressRepository.walletAddress)
    }


    private fun initViewModel() {
        walletViewModel.init(viewLifecycleOwner,
            loading = {
                if (it) {
                    nsv.gone()
                    pbLoading.visible()
                } else {
                    pbLoading.gone()
                    nsv.visible()
                }
            },
            error = {
                requireActivity().showToast(getString(R.string.error_check_inet_connection))
            },
            result = {
                when (it) {
                    is Result.Success -> updateWalletInfo(it.data)
                    is Result.Error -> handleError(it)
                }
            })
    }

    private fun updateWalletInfo(wallet: Wallet) {

        coinsAdapter.update(requireActivity().mapToBalanceItems(wallet.walletInfo.balances))
        delegatedAdapter.update(requireActivity().mapToDelegationItems(wallet.delegationInfo.data))
    }

    private fun handleError(it: Result.Error<String>) {
        requireActivity().showToast(it.error)
    }

}




