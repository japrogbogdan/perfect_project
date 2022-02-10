package com.competo.feature_auth

import com.competo.feature_auth.presentation.AuthOtpViewModel
import com.competo.feature_auth.presentation.AuthPhoneViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

fun createAuthModule() : List<Module> {

    val viewModels = module {
       viewModel{ AuthPhoneViewModel() }
       viewModel{ AuthOtpViewModel() }
    }

    return arrayListOf(viewModels)
}