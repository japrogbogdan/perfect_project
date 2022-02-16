package com.competo.feature_auth.data.repositories

import com.competo.feature_auth.data.mappers.CheckOtpAndConfirmMapper
import com.competo.feature_auth.data.models.AccessTokenResponse
import com.competo.feature_auth.data.models.OtpCodeRequest
import com.competo.feature_auth.domain.entities.AccessToken

class AuthRepository(private val api: AuthServiceApi) : AuthRepositoryInterface {

    override suspend fun enterViaPhone(phone: String) = api.enterViaPhone(phone)

    override suspend fun checkOtpAndConfirm(otp: OtpCodeRequest): AccessToken =
        convertToDomain(api.checkOtpAndConfirm(otp))

    private fun convertToDomain(model: Any): AccessToken =
        CheckOtpAndConfirmMapper(model as AccessTokenResponse).model
}