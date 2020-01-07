package com.minter.info.app.features.main.status

import com.minter.info.app.core.data.remote.MinterExplorerApi
import com.minter.info.app.core.data.remote.models.status.StatusInfoResponse
import retrofit2.Response

class StatusRepository(private val api: MinterExplorerApi) {
    suspend fun getStatusInfo(): Response<StatusInfoResponse> {
        return api.getStatusInfo()
    }
}