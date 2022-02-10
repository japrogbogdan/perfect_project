package com.competo.feature_auth

import com.competo.core.presentation.viewModel.BaseViewModel
import com.competo.feature_auth.presentation.AuthOtpViewModel
import com.competo.feature_auth.presentation.AuthPhoneViewModel
import com.competo.feature_auth.presentation.navigation.FeatureAuthNavigator
import com.competo.feature_auth.presentation.navigation.FeatureAuthNavigatorInterface
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.binds
import org.koin.dsl.module

fun createAuthModule(): List<Module> {

    val viewModels = module {

        viewModel { AuthPhoneViewModel() }
        viewModel { AuthOtpViewModel() }
    }

    return arrayListOf(viewModels)
}

val createAuthNavigationModule: Module = module {
    factory { (viewModel: BaseViewModel) -> FeatureAuthNavigator(viewModel) } binds arrayOf(
        FeatureAuthNavigatorInterface::class
    )
}
