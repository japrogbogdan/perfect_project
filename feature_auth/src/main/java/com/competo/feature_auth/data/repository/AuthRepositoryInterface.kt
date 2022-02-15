package com.competo.feature_auth.data.repository

import com.competo.feature_auth.data.model.OtpCodeRequest
import com.competo.feature_auth.domain.entity.AccessToken

interface AuthRepositoryInterface {

    suspend fun enterViaPhone(phone: String): Any

    suspend fun checkOtpAndConfirm(otp: OtpCodeRequest): AccessToken
}