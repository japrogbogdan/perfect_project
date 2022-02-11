package com.competo.feature_auth.presentation.navigation

import android.os.Bundle
import androidx.core.os.bundleOf
import com.competo.core.presentation.navigation.FragmentDirection
import com.competo.feature_auth.R
import com.competo.feature_auth.presentation.AuthOtpFragment

class AuthOtpFragmentDirection(private val phoneNumber: String) : FragmentDirection {

    override fun navigate(body: (fragmentDestinationId: Int, bundle: Bundle) -> Unit) {
        body.invoke(
            R.id.authOtpFragment,
            bundleOf(AuthOtpFragment.AUTH_OTP_FRAGMENT_PHONE to phoneNumber)
        )
    }
}