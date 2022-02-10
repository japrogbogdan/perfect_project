package com.competo.perfect_project

import android.app.Application
import com.competo.core.base.di.KoinManager
import com.competo.core.base.di.createCoreModules
import com.competo.feature_auth.createAuthModule
import com.competo.navigation.createNavigationModule
import org.koin.core.component.KoinComponent
import org.koin.core.module.Module

class App : Application(), KoinComponent {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        KoinManager.insertKoin(this, createModules())
    }

    private fun createModules(): List<Module> {
        val modules = arrayListOf<Module>()
        modules.addAll(createCoreModules())
        modules.addAll(createAuthModule())
        modules.addAll(createNavigationModule())
        return modules
    }
}