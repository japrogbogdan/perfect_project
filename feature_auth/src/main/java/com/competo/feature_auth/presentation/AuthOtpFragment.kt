package com.competo.feature_auth.presentation

import com.competo.core.presentation.fragment.BaseBindingFragment
import com.competo.feature_auth.R
import com.competo.feature_auth.databinding.AuthOtpLayoutBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class AuthOtpFragment : BaseBindingFragment<AuthOtpLayoutBinding, AuthOtpViewModel>() {

    companion object {

        const val AUTH_OTP_FRAGMENT_PHONE = "AUTH_OTP_FRAGMENT_PHONE"
    }

    override fun bindingViewModelEqualViewModel() {
        binding.viewModel = viewModel
    }

    override fun getLayoutRes(): Int = R.layout.auth_otp_layout

    override val viewModel: AuthOtpViewModel by viewModel()

}