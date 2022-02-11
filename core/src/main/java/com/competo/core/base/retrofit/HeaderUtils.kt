package com.competo.core.base.retrofit

import com.competo.core.presentation.preferences.PreferencesHelper
import okhttp3.Headers
import org.koin.core.component.KoinComponent

object HeaderUtils : KoinComponent {

    private const val AUTHORIZATION_HEADER_NAME = "Authorization"
    private const val ACCEPT_LANG_HEADER_NAME = "Accept-Language"
    private const val CONTENT_LANG_HEADER_NAME = "Content-Language"
    private const val HTTP_CONTENT_LANGUAGE = "HTTP_CONTENT_LANGUAGE"
    private const val HTTP_ACCEPT_LANGUAGE = "HTTP_ACCEPT_LANGUAGE"
    private const val X_USER_AGENT = "X-User-Agent"
    private const val X_APP_VERSION = "X-App-Version"
    private const val TRACE_SESSION = "X-Trace-ID"
    private const val ACCEPT = "Accept"
    private const val API_KEY = "ApiKey"

    private const val APPLICATION_JSON = "application/json, text/plain, */*"
    private const val BEARER_PATTERN = "Bearer %s"
    private const val X_USER_AGENT_VALUE = "android"

    fun getRetrofitHeader(preferencesHelper: PreferencesHelper): Headers {
        return Headers.headersOf(
            ACCEPT, APPLICATION_JSON,
            AUTHORIZATION_HEADER_NAME, String.format(BEARER_PATTERN, preferencesHelper.accessToken),
            ACCEPT_LANG_HEADER_NAME, preferencesHelper.language,
            CONTENT_LANG_HEADER_NAME, preferencesHelper.language,
            HTTP_CONTENT_LANGUAGE, preferencesHelper.language,
            HTTP_ACCEPT_LANGUAGE, preferencesHelper.language,
            X_USER_AGENT, X_USER_AGENT_VALUE,
            X_APP_VERSION,"1",
            TRACE_SESSION,preferencesHelper.session,
            API_KEY,preferencesHelper.apiKey
        )
    }

    fun getAuthRetrofitHeader(preferencesHelper: PreferencesHelper) : Headers{
        return Headers.headersOf(
            ACCEPT, APPLICATION_JSON,
            ACCEPT_LANG_HEADER_NAME, preferencesHelper.language,
            CONTENT_LANG_HEADER_NAME, preferencesHelper.language,
            HTTP_CONTENT_LANGUAGE, preferencesHelper.language,
            HTTP_ACCEPT_LANGUAGE, preferencesHelper.language,
            X_USER_AGENT, X_USER_AGENT_VALUE,
            X_APP_VERSION,"1",
            TRACE_SESSION,preferencesHelper.session,
        )
    }
}