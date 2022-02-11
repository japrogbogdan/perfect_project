package com.competo.feature_auth.di

import com.competo.core.base.retrofit.provideAuthOkHttpClient
import com.competo.core.base.retrofit.provideOkHttpClient
import com.competo.core.base.retrofit.provideRetrofit
import com.competo.feature_auth.presentation.AuthOtpViewModel
import com.competo.feature_auth.presentation.AuthPhoneViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val AUTH_OKHTTP_KOIN_TAG = "AUTH_OKHTTP_KOIN_TAG"
const val OKHTTP_KOIN_TAG = "OKHTTP_KOIN_TAG"
const val RETROFIT_KOIN_TAG = "RETROFIT_KOIN_TAG"
const val AUTH_RETROFIT_KOIN_TAG = "AUTH_RETROFIT_KOIN_TAG"

fun createAuthModule(): List<Module> {

    val viewModels = module {
        viewModel { AuthPhoneViewModel() }
        viewModel { AuthOtpViewModel() }
    }

    val repository = module {
        factory(named(AUTH_RETROFIT_KOIN_TAG)) {
            provideRetrofit(get(named(AUTH_OKHTTP_KOIN_TAG)))
        }
        factory(named(RETROFIT_KOIN_TAG)) {
            provideRetrofit(get(named(OKHTTP_KOIN_TAG)))
        }
        factory(named(AUTH_OKHTTP_KOIN_TAG)) { provideAuthOkHttpClient(get()) }
        factory(named(OKHTTP_KOIN_TAG)) { provideOkHttpClient(get()) }
    }

    return arrayListOf(viewModels, repository)
}
