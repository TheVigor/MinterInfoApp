package com.minter.info.app.core.extentions.activities

import android.app.Activity
import android.content.Intent
import com.minter.info.app.MainActivity
import com.minter.info.app.core.data.remote.models.validators.Validator
import com.minter.info.app.core.extentions.open
import com.minter.info.app.features.login.LoginActivity
import com.minter.info.app.features.main.validators.detail.ValidatorDetailActivity
import com.minter.info.app.features.main.validators.detail.ValidatorDetailActivity.Companion.VALIDATOR_DATA

fun Activity.goToLogin() {
    open<LoginActivity>()
    finish()
}

fun Activity.goToMain() {
    open<MainActivity>()
    finish()
}

fun Activity.logout() {
    val intent = Intent(this, LoginActivity::class.java).apply {
        addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    startActivity(intent)
}

fun Activity.goToValidatorDetail(validator: Validator) {
    val intent = Intent(this, ValidatorDetailActivity::class.java).apply {
        putExtra(VALIDATOR_DATA, validator)
    }
    startActivity(intent)
}
