package com.competo.core.presentation.preferences

import android.content.Context

class PreferencesHelper(context: Context) {

    var accessToken: String = ""
        private set

    var language: String = ""
        private set

    var session: String = ""
        private set

    var apiKey: String = ""
        private set
}