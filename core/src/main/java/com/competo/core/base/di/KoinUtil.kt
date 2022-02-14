package com.competo.core.base.di

import retrofit2.Retrofit

inline fun <reified T> provideService(retrofit: Retrofit): T = retrofit.create(T::class.java)
