package com.minter.info.app.core.extentions

fun Double.round(decimals: Int = 2): Double =
    "%.${decimals}f"
        .format(this)
        .replace(",", ".")
        .toDouble()