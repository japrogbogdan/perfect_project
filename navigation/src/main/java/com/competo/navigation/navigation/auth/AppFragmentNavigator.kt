package com.competo.navigation.navigation.auth

import com.competo.core.presentation.navigation.Navigator
import com.competo.core.presentation.viewModel.BaseViewModel
import com.competo.feature_auth.presentation.navigation.AuthOtpDirection
import com.competo.feature_auth.presentation.navigation.FeatureAuthNavigatorInterface

class AppFragmentNavigator(private val viewModel: BaseViewModel) : Navigator,
    FeatureAuthNavigatorInterface {

    override fun openOtpCode(phoneNumber: String) {
        viewModel.navigate(AuthOtpDirection(phoneNumber))
    }
}