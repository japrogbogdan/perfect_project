package com.competo.navigation.navigation.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.competo.core.presentation.navigation.INavigatorNavigable
import com.competo.feature_auth.presentation.AuthActivity
import com.competo.feature_auth.presentation.AuthOtpFragment

class OpenAuthOtpFragmentNavigation(val phoneNumber: String) : INavigatorNavigable {

    override fun navigate(
        navController: NavController,
        fromActivity: AppCompatActivity,
        fromFragment: Fragment?
    ) {
        when (fromActivity) {
            is AuthActivity -> {
                navController.navigate(
                    com.competo.feature_auth.R.id.authOtpFragment,
                    createBundleForFragment()
                )
            }
        }
    }

    private fun createBundleForFragment(): Bundle {
        val bundle = Bundle()
        bundle.putSerializable(AuthOtpFragment.AUTH_OTP_FRAGMENT_PHONE, phoneNumber)
        return bundle
    }
}