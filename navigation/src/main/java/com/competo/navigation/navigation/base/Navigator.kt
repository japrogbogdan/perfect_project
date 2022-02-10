package com.competo.navigation.navigation.base

import com.competo.core.presentation.navigation.INavigator
import com.competo.core.presentation.viewModel.BaseViewModel
import com.competo.feature_auth.presentation.navigation.IFeatureAuthNavigator
import com.competo.navigation.navigation.auth.OpenAuthOtpFragmentNavigation

class Navigator(private val viewModel: BaseViewModel) : INavigator, IFeatureAuthNavigator {

    override fun openOtpCode(phoneNumber: String) {
        viewModel.navigate(OpenAuthOtpFragmentNavigation(phoneNumber))
    }
}
