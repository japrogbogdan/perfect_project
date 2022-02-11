package com.competo.navigation.di

import com.competo.core.presentation.viewModel.BaseViewModel
import com.competo.feature_auth.presentation.navigation.FeatureAuthNavigatorInterface
import com.competo.navigation.AppFragmentNavigator
import org.koin.core.module.Module
import org.koin.dsl.binds
import org.koin.dsl.module

fun createNavigationModule(): ArrayList<Module> =
    arrayListOf(createFragmentNavigationModule)

val createFragmentNavigationModule: Module = module {
    factory { (viewModel: BaseViewModel) -> AppFragmentNavigator(viewModel) } binds arrayOf(
        FeatureAuthNavigatorInterface::class
    )
}