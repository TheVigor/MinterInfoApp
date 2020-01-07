package com.minter.info.app.features.main.validators

import android.content.Context
import com.minter.info.app.R
import com.minter.info.app.core.base.BaseViewModel
import com.minter.info.app.core.base.Result
import com.minter.info.app.core.data.remote.models.validators.Validator

class ValidatorsViewModel(
    private val context: Context,
    private val validatorsRepository: ValidatorsRepository
): BaseViewModel<List<Validator>, String>(){

    fun getValidators() {
        launchDataLoad {
            val response = validatorsRepository.getValidators()
            if (response.isSuccessful) {
                contentState.postValue(Result.Success(response.body()?.data?.filter { it.meta.name != null } ?: listOf()))
            } else {
                contentState.postValue(Result.Error(context.getString(R.string.error_get_validators)))
            }
        }
    }
}