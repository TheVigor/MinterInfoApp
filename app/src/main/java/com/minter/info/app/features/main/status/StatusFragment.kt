package com.minter.info.app.features.main.status

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.minter.info.app.R
import com.minter.info.app.core.base.BaseActivity
import com.minter.info.app.core.base.Result
import com.minter.info.app.core.data.remote.models.status.StatusInfo
import com.minter.info.app.core.extentions.*
import com.minter.info.app.core.extentions.activities.logout
import com.minter.info.app.core.extentions.activities.showQuestionAlertDialog
import kotlinx.android.synthetic.main.fragment_status.*
import kotlinx.android.synthetic.main.fragment_validators.*
import kotlinx.android.synthetic.main.fragment_validators.pbLoading
import org.koin.android.viewmodel.ext.android.viewModel


class StatusFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = StatusFragment()
    }

    private val statusViewModel: StatusViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_status, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initToolbar()
        initViewModel()

        statusViewModel.getStatusInfo()
    }

    private fun initToolbar() {
        ivDonate.setOnClickListener {
            requireActivity().showQuestionAlertDialog(
                title = getString(R.string.donation),
                message = getString(R.string.donate_message),
                positiveMessageId = R.string.copy,
                positiveAction = { _, _ ->
                    requireActivity().copyToClipboard()
                }
            )
        }


        ivLogout.setOnClickListener {
            requireActivity().showQuestionAlertDialog(
                title = getString(R.string.change_wallet_address),
                message = getString(R.string.are_you_sure_to_change_wallet_address),
                positiveAction = { _, _ ->
                    (requireActivity() as BaseActivity).walletAddressRepository.walletAddress = ""
                    requireActivity().logout()
                }
            )
        }
    }

    private fun initViewModel() {
        statusViewModel.init(viewLifecycleOwner,
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
                    is Result.Success -> updateStatusInfo(it.data)
                    is Result.Error -> handleError(it)
                }
            })
    }


    private fun handleError(it: Result.Error<String>) {
        requireActivity().showToast(it.error)
    }

    private fun updateStatusInfo(statusInfo: StatusInfo) {
        tvMarketCap.text = "$ ${(statusInfo.marketCap / 1000000).round()} M"
        tvUsdPrice.text = "$ ${statusInfo.bipPriceUsd}"

        tvLastBlockHeight.text = statusInfo.latestBlockHeight.toString()
        tvBlockTime.text = "${statusInfo.averageBlockTime.round()}${getString(R.string.s)}"

        tvTotalTransactions.text = statusInfo.totalTransactions.toString()
        tvTransactionPerSecond.text = "${statusInfo.transactionsPerSecond.round()} TPS"
    }
}
