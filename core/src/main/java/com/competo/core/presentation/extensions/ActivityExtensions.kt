package com.competo.core.presentation

import android.content.res.Configuration
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import com.competo.core.data.LocaleRepository
import com.competo.core.base.ContextResources
import org.koin.android.ext.android.get

fun AppCompatActivity.updateConfigurationIfSupported(): Configuration {

    val localeRepository = get<LocaleRepository>()
    localeRepository.updateLocale()

    val modifiedContext = localeRepository.modifyContext(baseContext)

    val contextResources = get<ContextResources>()
    contextResources.baseContext = modifiedContext

    val configMod = contextResources.resources.configuration

    // Configuration.getLocales is added after 24 and Configuration.locale is deprecated in 24
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        if (!configMod.locales.isEmpty) {
            return configMod
        }
    } else {
        if (configMod.locale != null) {
            return configMod
        }
    }

    return configMod
}