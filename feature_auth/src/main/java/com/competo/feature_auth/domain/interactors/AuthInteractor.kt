package com.competo.feature_auth.domain.interactors

import com.competo.feature_auth.data.model.AccessTokenResponse
import com.competo.feature_auth.data.model.OtpCodeRequest
import com.competo.feature_auth.data.repository.AuthRepository
import com.competo.feature_auth.data.repository.AuthRepositoryInterface
import com.competo.feature_auth.domain.entity.AccessToken
import kotlin.coroutines.suspendCoroutine

class AuthInteractor(private val repository: AuthRepository) {

    suspend fun sentOtpCode(phone: String, otp: String): AccessToken? {
        return  try {
            repository.checkOtpAndConfirm(OtpCodeRequest(otp, phone))
        }catch (e : Exception){
            return null
        }
    }
}