package com.competo.feature_auth.presentation.navigation

import android.os.Bundle
import androidx.core.os.bundleOf
import com.competo.core.presentation.navigation.DirectionNavigator
import com.competo.feature_auth.presentation.AuthOtpFragment

class AuthOtpDirection(private val phoneNumber: String) : DirectionNavigator {

    override fun navigate(body: (fragmentDestinationId: Int, bundle: Bundle) -> Unit) {
        body.invoke(com.competo.feature_auth.R.id.authOtpFragment,
            bundleOf(AuthOtpFragment.AUTH_OTP_FRAGMENT_PHONE to phoneNumber))
    }
}