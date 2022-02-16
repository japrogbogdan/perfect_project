package com.competo.feature_auth.data.repositories

import com.competo.feature_auth.data.models.OtpCodeRequest
import com.competo.feature_auth.domain.entities.AccessToken

interface AuthRepositoryInterface {

    suspend fun enterViaPhone(phone: String): Any

    suspend fun checkOtpAndConfirm(otp: OtpCodeRequest): AccessToken
}