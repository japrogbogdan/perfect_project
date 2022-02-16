package com.competo.feature_auth.data.mappers

import com.competo.core.data.mapper.BaseMapper
import com.competo.feature_auth.data.models.AccessTokenResponse
import com.competo.feature_auth.domain.entities.AccessToken

class CheckOtpAndConfirmMapper(tokenModel: AccessTokenResponse) :
    BaseMapper<AccessTokenResponse>(tokenModel) {

    val model by lazy {
        AccessToken(
            validateNullOrEmpty(AccessTokenResponse::accessToken)
        )
    }
}