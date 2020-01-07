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
    positiveMessageId: Int = R.string.yes,
    negativeMessageId: Int = R.string.cancel,
    positiveAction: (DialogInterface, Int) -> Unit,
    negativeAction: (DialogInterface, Int) -> Unit = { _, _ -> }) {
    val builder = AlertDialog.Builder(this)

    with(builder) {
        setTitle(title)
        setMessage(message)
        setPositiveButton(getString(positiveMessageId), positiveAction)
        setNegativeButton(getString(negativeMessageId), negativeAction)
        show()
    }
}
