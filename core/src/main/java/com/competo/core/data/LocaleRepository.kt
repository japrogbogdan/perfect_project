package com.competo.core.data

import android.content.Context
import android.os.Build
import android.os.LocaleList
import java.util.*

//TODO inject preferences helper
class LocaleRepository {

    companion object {

        const val RU_LOCALE_CODE = "ru"
        const val EN_LOCALE_CODE = "en"
    }

    fun updateLocale() {

    }

    fun modifyContext(context: Context?): Context? {
        context?.let {
            return modifyContextNotNull(it)
        }
        return context
    }

    private fun findLocale(localeStr: String): Locale {
        if (localeStr.isNotEmpty()) {
            val locales = Locale.getAvailableLocales()
            locales.forEach { locale ->
                if (locale.toString() == localeStr) {
                    return locale
                }
            }
        }
        return Locale(RU_LOCALE_CODE)
    }

    fun modifyContextNotNull(context: Context): Context {
        val locale = getLocaleForContext()
        var contextModified = context
        val res = contextModified.resources
        val configuration = res.configuration
        contextModified = when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.N -> {
                val localeList = LocaleList(locale)
                configuration.setLocales(localeList)
                configuration.setLocale(locale)
                LocaleList.setDefault(localeList)
                contextModified.createConfigurationContext(configuration)
            }
            else -> {
                configuration.setLocale(locale)
                contextModified.createConfigurationContext(configuration)
            }
        }
        return contextModified
    }

    private fun getLocaleForContext(): Locale {
        // TODO Get locale from prefs settings
        val localeCode = ""
        return findLocale(localeCode)
    }
}