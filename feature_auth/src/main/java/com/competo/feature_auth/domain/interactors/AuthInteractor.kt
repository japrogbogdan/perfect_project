package com.competo.feature_auth.domain.interactors

import com.competo.core.domain.interactors.BaseInteractor
import com.competo.feature_auth.data.model.OtpCodeRequest
import com.competo.feature_auth.data.repository.AuthRepository
import com.competo.feature_auth.domain.entity.AccessToken
import kotlinx.coroutines.delay

class AuthInteractor(private val repository: AuthRepository) : BaseInteractor() {

    suspend fun enterViaPhone(phone: String = "+994505470154"): Result<Any> =
        makeApiRequest { repository.enterViaPhone(phone) }

    suspend fun sentOtpCode(phone: String = "+994505470154", otp: String = "0000"): Result<AccessToken> =
        makeApiRequest {
            delay(5000)
            repository.checkOtpAndConfirm(OtpCodeRequest(otp, phone))
        }
}