package com.competo.feature_auth.data.repository

import com.competo.feature_auth.data.model.OtpCodeRequest
import com.competo.feature_auth.domain.entity.AccessToken

class AuthRepository(private val api : IAuthService) : IAuthRepository{

    override fun checkOtpAndConfirm(otp: OtpCodeRequest): AccessToken {
        return api.checkOtpAndConfirm(otp).map {
            AccessToken("")
        }
    }
}