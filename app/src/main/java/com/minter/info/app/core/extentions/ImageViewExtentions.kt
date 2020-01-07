package com.minter.info.app.core.extentions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(image: String?) {
    if (!image.isNullOrEmpty()) {
        Glide
            .with(this)
            .load(image)
            .into(this)
    }
}