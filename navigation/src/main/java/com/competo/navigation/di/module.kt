package com.competo.navigation

import com.competo.feature_auth.createAuthNavigationModule
import org.koin.core.module.Module

fun createNavigationModule(): ArrayList<Module> =
    arrayListOf(createAuthNavigationModule)