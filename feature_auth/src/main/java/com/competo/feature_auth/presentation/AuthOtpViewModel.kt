package com.competo.feature_auth.presentation

import com.competo.core.presentation.viewModel.BaseViewModel
import com.competo.feature_auth.presentation.navigation.FeatureAuthNavigator
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

class AuthOtpViewModel : BaseViewModel() {

    override val navigator: FeatureAuthNavigator by inject { parametersOf(this) }
}