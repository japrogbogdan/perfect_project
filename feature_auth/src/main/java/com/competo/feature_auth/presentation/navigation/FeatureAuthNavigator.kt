package com.competo.feature_auth.presentation.navigation

import com.competo.core.presentation.navigation.Navigator
import com.competo.core.presentation.viewModel.BaseViewModel

interface FeatureAuthNavigatorInterface : Navigator {
    fun openOtpCode(phoneNumber: String)
}

class FeatureAuthNavigator(val viewModel: BaseViewModel) : Navigator,
    FeatureAuthNavigatorInterface {

    override fun openOtpCode(phoneNumber: String) {
        viewModel.navigate(AuthOtpDirection(phoneNumber))
    }
}