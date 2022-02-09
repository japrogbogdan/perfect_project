package com.competo.core.base.di

import com.competo.core.base.ContextResources
import com.competo.core.data.LocaleRepository
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

fun createCoreModules(): List<Module> {

    val context = module {
        single {
            with(get<LocaleRepository>()) {
                updateLocale()
                ContextResources(modifyContextNotNull(androidContext()))
            }
        }
    }

    val repository = module {
        factory { LocaleRepository() }
    }

    return arrayListOf(context,repository)
}