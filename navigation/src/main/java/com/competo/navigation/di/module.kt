package com.competo.navigation

import com.competo.core.presentation.navigation.INavigator
import com.competo.core.presentation.viewModel.BaseViewModel
import com.competo.feature_auth.presentation.navigation.IFeatureAuthNavigator
import com.competo.navigation.navigation.base.Navigator
import org.koin.core.module.Module
import org.koin.dsl.binds
import org.koin.dsl.module

fun createNavigationModule(): ArrayList<Module> {

    val navigation = module {
        factory { (viewModel: BaseViewModel) -> Navigator(viewModel) } binds arrayOf(
            INavigator::class, IFeatureAuthNavigator::class
        )
    }
    return arrayListOf(navigation)
}