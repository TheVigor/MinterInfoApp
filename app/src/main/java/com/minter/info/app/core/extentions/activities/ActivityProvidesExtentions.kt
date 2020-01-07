package com.minter.info.app.core.extentions.activities

import android.app.Activity
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import com.minter.info.app.R

fun Activity.provideProgressDialog(): AlertDialog =
    AlertDialog.Builder(this).apply {
        setCancelable(false)
        setView(R.layout.layout_loading_dialog)
    }.create()



fun Activity.showQuestionAlertDialog(
    title: String,
    message: String,
    positiveAction: (DialogInterface, Int) -> Unit,
    negativeAction: (DialogInterface, Int) -> Unit = { _, _ -> }) {
    val builder = AlertDialog.Builder(this)

    with(builder) {
        setTitle(title)
        setMessage(message)
        setPositiveButton(getString(R.string.yes), positiveAction)
        setNegativeButton(getString(R.string.cancel), negativeAction)
        show()
    }
}