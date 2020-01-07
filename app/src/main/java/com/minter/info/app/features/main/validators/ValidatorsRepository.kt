package com.minter.info.app.features.main.validators

import com.minter.info.app.core.data.remote.MinterExplorerApi
import com.minter.info.app.core.data.remote.models.validators.ValidatorsResponse
import retrofit2.Response

class ValidatorsRepository(private val api: MinterExplorerApi) {
    suspend fun getValidators(): Response<ValidatorsResponse> {
        return api.getValidators()
    }
}