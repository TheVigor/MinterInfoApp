package com.minter.info.app.features.main.validators

import android.graphics.drawable.Drawable
import android.view.View
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.minter.info.app.R
import com.minter.info.app.core.data.remote.models.validators.Validator
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_validator.*

class ValidatorItem (
    private val validator: Validator,
    private val click: (Validator) -> Unit) : Item() {

    override fun getLayout() = R.layout.item_validator

    override fun bind(viewHolder: com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder, position: Int) {
        viewHolder.apply {

            if (!validator.meta.iconUrl.isNullOrEmpty()) {
                Glide
                    .with(ivValidatorImage)
                    .load(validator.meta.iconUrl)
                    .apply(RequestOptions.circleCropTransform())
                    .into(ivValidatorImage)
            }

            tvValidatorTitle.text = validator.meta.name ?: ""

            clRoot.setOnClickListener {
                click(validator)
            }
        }
    }
}