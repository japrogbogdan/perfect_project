package com.competo.feature_auth.domain.interactors

import com.competo.feature_auth.data.model.OtpCodeRequest
import com.competo.feature_auth.data.repository.IAuthRepository

class AuthInteractor(private val repository : IAuthRepository) {

    fun sendOtpCode(phone : String, otp: String){
        repository.checkOtpAndConfirm(
            OtpCodeRequest(otp,phone)
        )
    }
}