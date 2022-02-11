package com.competo.core.base.retrofit

import android.text.TextUtils
import com.competo.core.data.ServerException
import com.competo.core.data.SessionExpiredException
import com.competo.core.presentation.preferences.PreferencesHelper
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
    Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(okHttpClient)
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

fun provideOkHttpClient(preferences: PreferencesHelper): OkHttpClient =
    OkHttpClient().newBuilder()
        .addInterceptor { chain ->
            val requestBuilder: Request.Builder = chain.request().newBuilder()
            if (TextUtils.isEmpty(preferences.accessToken)) {
                throw SessionExpiredException()
            }
            HeaderUtils.getRetrofitHeader(preferences).forEach {
                requestBuilder.addHeader(it.first, it.second)
            }
            val response: Response = chain.proceed(requestBuilder.build())
            if (!response.isSuccessful) {
                throw ServerException(response.code, response.message, response)
            }
            response
        }
        .setupLogging()
        .build()

fun provideAuthOkHttpClient(preferences: PreferencesHelper): OkHttpClient =
    OkHttpClient().newBuilder()
        .addInterceptor { chain ->
            val requestBuilder: Request.Builder = chain.request().newBuilder()
            HeaderUtils.getAuthRetrofitHeader(preferences).forEach {
                requestBuilder.addHeader(it.first, it.second)
            }
            return@addInterceptor chain.proceed(requestBuilder.build())
        }
        .setupLogging()
        .build()