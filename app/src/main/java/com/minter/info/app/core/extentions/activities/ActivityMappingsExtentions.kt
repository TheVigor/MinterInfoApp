package com.minter.info.app.core.extentions.activities

import android.app.Activity
import com.minter.info.app.core.data.remote.models.validators.Validator
import com.minter.info.app.core.extentions.showToast
import com.minter.info.app.features.main.validators.ValidatorItem

fun Activity.mapToValidatorItems(validators: List<Validator>): List<ValidatorItem> {
    return validators.map {
        ValidatorItem(it) { validator ->
            showToast(validator.meta.name ?: "XXX")
        }
    }
}