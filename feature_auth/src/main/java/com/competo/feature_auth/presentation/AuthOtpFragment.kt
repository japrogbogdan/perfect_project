package com.competo.feature_auth.presentation

import android.os.Bundle
import android.view.View
import com.competo.core.presentation.fragment.BaseBindingFragment
import com.competo.feature_auth.R
import com.competo.feature_auth.databinding.AuthOtpLayoutBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class AuthOtpFragment : BaseBindingFragment<AuthOtpLayoutBinding, AuthOtpViewModel>(R.layout.auth_otp_layout) {

    companion object {

        const val AUTH_OTP_FRAGMENT_PHONE = "AUTH_OTP_FRAGMENT_PHONE"
    }

    override fun bindingViewModelEqualViewModel() {
        binding.viewModel = viewModel
    }

    override val viewModel: AuthOtpViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val phone = getStringExtra(AUTH_OTP_FRAGMENT_PHONE)

    }
}