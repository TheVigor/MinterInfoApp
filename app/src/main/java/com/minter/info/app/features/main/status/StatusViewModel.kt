package com.minter.info.app.features.main.status

import android.content.Context
import com.minter.info.app.R
import com.minter.info.app.core.base.BaseViewModel
import com.minter.info.app.core.base.Result
import com.minter.info.app.core.data.remote.models.status.StatusInfo

class StatusViewModel(
    private val context: Context,
    private val statusRepository: StatusRepository
): BaseViewModel<StatusInfo, String>(){

    fun getStatusInfo() {
        launchDataLoad {
            val response = statusRepository.getStatusInfo()
            if (response.isSuccessful) {
                contentState.postValue(Result.Success(response.body()!!.data))
            } else {
                contentState.postValue(Result.Error(context.getString(R.string.error_get_status_info)))
            }
        }
    }
}