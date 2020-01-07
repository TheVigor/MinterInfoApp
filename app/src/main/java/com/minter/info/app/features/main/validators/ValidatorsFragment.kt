package com.minter.info.app.features.main.validators

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.minter.info.app.R

class ValidatorsFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = ValidatorsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_validators, container, false)
    }

}
