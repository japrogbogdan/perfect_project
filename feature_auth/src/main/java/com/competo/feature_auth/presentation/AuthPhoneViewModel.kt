package com.competo.feature_auth.presentation

import com.competo.core.presentation.viewModel.BaseViewModel
import com.competo.feature_auth.presentation.navigation.FeatureAuthNavigatorInterface
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

class AuthPhoneViewModel : BaseViewModel() {

    override val navigator: FeatureAuthNavigatorInterface by inject { parametersOf(this) }

    fun sendPhone(phoneNumber: String) {
        // request for phone
        // get answer and navigate
        navigator.openOtpCode(phoneNumber)
    }
}