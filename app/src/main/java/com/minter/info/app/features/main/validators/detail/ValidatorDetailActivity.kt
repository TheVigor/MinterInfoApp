package com.minter.info.app.features.main.validators.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.minter.info.app.R
import com.minter.info.app.core.data.remote.models.validators.Validator
import com.minter.info.app.core.extentions.copyToClipboard
import com.minter.info.app.core.extentions.loadImage
import com.minter.info.app.core.extentions.round
import kotlinx.android.synthetic.main.activity_validator_detail.*

class ValidatorDetailActivity : AppCompatActivity() {

    companion object {
        const val VALIDATOR_DATA = "validator_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_validator_detail)

        initToolbar()


        val validator = intent.getParcelableExtra<Validator>(VALIDATOR_DATA)

        validator ?: return

        val url = validator.meta.iconUrl

        if (!url.isNullOrEmpty()) {
            ivValidatorDetailImage.loadImage(url)
        }

        val name = validator.meta.name ?: ""

        tvToolbarTitle.text = if (name.length > 20) name.substring(0, 20) + "..." else name

        tvValidatorDetailName.text = name
        tvValidatorDetailPublicKey.text = validator.publicKey

        ivCopyDetailPublicKey.setOnClickListener {
            copyToClipboard(
                text = validator.publicKey,
                messageId = R.string.address_copied
            )
        }

        tvValidatorDetailDescription.text = validator.meta.description

        val site = validator.meta.siteUrl ?: ""

        tvValidatorDetailSite.text = site

        ivSite.setOnClickListener {
            copyToClipboard(
                text = site,
                messageId = R.string.site_copied
            )
        }

        val part = validator.part ?: 0.0
        tvValidatorDetailPart.text = part.round().toString() + " %"

        tvValidatorDetailStake.text = (validator.stake / 1000000).round().toString() + " M BIP"

    }

    private fun initToolbar() {
        ivBack.setOnClickListener {
            finish()
        }
    }
}
