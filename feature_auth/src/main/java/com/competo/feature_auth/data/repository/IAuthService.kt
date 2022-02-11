package com.competo.feature_auth.data.repository

import com.competo.feature_auth.data.model.AccessTokenResponse
import com.competo.feature_auth.data.model.OtpCodeRequest
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface IAuthService {

    companion object {

        private const val URL_CUSTOMER = "https://customer-stage.tibuy.bg"
    }

    @POST("$URL_CUSTOMER/v2/clients/account/check-otp-code-and-confirm")
    fun checkOtpAndConfirm(
        @Body otpCode: OtpCodeRequest
    ): Observable<AccessTokenResponse>
}