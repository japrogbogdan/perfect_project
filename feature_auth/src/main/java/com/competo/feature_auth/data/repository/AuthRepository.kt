package com.competo.feature_auth.data.repository

import com.competo.feature_auth.data.mapper.CheckOtpAndConfirmMapper
import com.competo.feature_auth.data.model.AccessTokenResponse
import com.competo.feature_auth.data.model.OtpCodeRequest
import com.competo.feature_auth.domain.entity.AccessToken

class AuthRepository(private val api: AuthServiceApi) : AuthRepositoryInterface {

    override suspend fun enterViaPhone(phone: String) = api.enterViaPhone(phone)

    override suspend fun checkOtpAndConfirm(otp: OtpCodeRequest): AccessToken =
        convertToDomain(api.checkOtpAndConfirm(otp))

    private fun convertToDomain(model: Any): AccessToken =
        CheckOtpAndConfirmMapper(model as AccessTokenResponse).model
}