package com.competo.feature_auth.presentation

import com.competo.core.presentation.viewModel.BaseViewModel
import com.competo.feature_auth.domain.interactors.AuthInteractor
import com.competo.feature_auth.presentation.navigation.FeatureAuthNavigatorInterface
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

class AuthOtpViewModel(private val interactor: AuthInteractor) : BaseViewModel() {

    override val navigator: FeatureAuthNavigatorInterface by inject { parametersOf(this) }
}