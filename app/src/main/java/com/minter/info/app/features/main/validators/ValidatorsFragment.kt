package com.minter.info.app.features.main.validators

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.minter.info.app.R
import com.minter.info.app.core.base.Result
import com.minter.info.app.core.data.remote.models.validators.Validator
import com.minter.info.app.core.extentions.activities.mapToValidatorItems
import com.minter.info.app.core.extentions.gone
import com.minter.info.app.core.extentions.showToast
import com.minter.info.app.core.extentions.visible
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.fragment_validators.*
import org.koin.android.viewmodel.ext.android.viewModel

class ValidatorsFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = ValidatorsFragment()
    }

    private val validatorsViewModel: ValidatorsViewModel by viewModel()

    private val validatorsAdapter = GroupAdapter<GroupieViewHolder>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_validators, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecycleView()
        initViewModel()

        validatorsViewModel.getValidators()
    }

    private fun initViewModel() {
        validatorsViewModel.init(viewLifecycleOwner,
            loading = {
                if (it) pbLoading.visible() else pbLoading.gone()
            },
            error = {
                requireActivity().showToast(getString(R.string.error_check_inet_connection))
            },
            result = {
                when (it) {
                    is Result.Success -> updateValidators(it.data.sortedBy { va -> va.part }.reversed())
                    is Result.Error -> handleError(it)
                }
            })
    }

    private fun initRecycleView() {
        rvValidators.adapter = validatorsAdapter

    }

    private fun handleError(it: Result.Error<String>) {
        requireActivity().showToast(it.error)
    }

    private fun updateValidators(articles: List<Validator>) {
        validatorsAdapter.update(requireActivity().mapToValidatorItems(articles))
    }

}
