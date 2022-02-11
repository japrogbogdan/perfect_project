package com.competo.core.base.retrofit

import com.competo.core.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

fun OkHttpClient.Builder.setupLogging(): OkHttpClient.Builder {
    val log = HttpLoggingInterceptor()
    log.level = if (BuildConfig.DEBUG) {
        HttpLoggingInterceptor.Level.BODY
    } else {
        HttpLoggingInterceptor.Level.NONE
    }
    this.addInterceptor(log)
    return this
}

