package com.minter.info.app.core.extentions.activities

import android.app.Activity
import com.minter.info.app.core.extentions.open
import com.minter.info.app.features.login.LoginActivity

fun Activity.goToLogin() {
    open<LoginActivity>()
    finish()
}