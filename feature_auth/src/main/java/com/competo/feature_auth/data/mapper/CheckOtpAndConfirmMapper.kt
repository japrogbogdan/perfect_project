package com.competo.feature_auth.data.mapper

import com.competo.core.data.mapper.BaseMapper
import com.competo.feature_auth.data.model.AccessTokenResponse
import com.competo.feature_auth.domain.entity.AccessToken

class CheckOtpAndConfirmMapper(tokenModel: AccessTokenResponse) :
    BaseMapper<AccessTokenResponse>(tokenModel) {

    val model by lazy {
        AccessToken(
            validateNullOrEmpty(AccessTokenResponse::accessToken)
        )
    }
}