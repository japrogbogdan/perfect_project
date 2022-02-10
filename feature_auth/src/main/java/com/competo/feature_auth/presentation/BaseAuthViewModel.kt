package com.competo.feature_auth.presentation

import com.competo.core.presentation.viewModel.BaseViewModel
import com.competo.feature_auth.presentation.navigation.IFeatureAuthNavigator
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

open class BaseAuthViewModel : BaseViewModel() {

    public override val navigator: IFeatureAuthNavigator by inject { parametersOf(this) }

}