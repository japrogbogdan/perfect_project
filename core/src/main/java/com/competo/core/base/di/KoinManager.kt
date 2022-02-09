package com.competo.core.base.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.context.unloadKoinModules
import org.koin.core.logger.Level
import org.koin.core.module.Module

object KoinManager {

    fun insertKoin(app: Application, moduleList: List<Module>) {
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(app)
            modules(moduleList)
        }
    }

    fun addModule(modules: List<Module>) {
        loadKoinModules(modules)
    }

    fun updateModule(modules: List<Module>) {
        unloadKoinModules(modules)
        loadKoinModules(modules)
    }
}