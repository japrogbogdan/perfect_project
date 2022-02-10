package com.competo.feature_auth.presentation

import android.os.Bundle
import android.view.View
import com.competo.core.presentation.fragment.BaseBindingFragment
import com.competo.feature_auth.R
import com.competo.feature_auth.databinding.AuthPhoneLayoutBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class AuthPhoneFragment : BaseBindingFragment<AuthPhoneLayoutBinding, AuthPhoneViewModel>() {

    override fun bindingViewModelEqualViewModel() {
        binding.viewModel = viewModel
    }

    override fun getLayoutRes(): Int = R.layout.auth_phone_layout

    override val viewModel: AuthPhoneViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.txt.setOnClickListener {
            viewModel.sendPhone("123456")

//            val request = NavDeepLinkBuilder(requireContext()).createPendingIntent().

//            val request = NavDeepLinkRequest.Builder
//                .fromUri("android-app://example.google.app/settings_fragment_two".toUri())
//                .build()

//            findNavController().createDeepLink()
//                .setGraph(R.navigation.graph_feature_auth)
//                .setArguments(bundleOf(AuthOtpFragment.AUTH_OTP_FRAGMENT_PHONE to "123456"))
//                .setDestination(R.id.authOtpFragment)

//            findNavController().navigate(R.id.authOtpFragment, bundleOf(AuthOtpFragment.AUTH_OTP_FRAGMENT_PHONE to "123456"))
        }
    }
}