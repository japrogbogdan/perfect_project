package com.competo.feature_auth.data.repository

import com.competo.feature_auth.data.model.AccessTokenResponse
import com.competo.feature_auth.data.model.OtpCodeRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthServiceApi {

    companion object {

        private const val URL_CUSTOMER = "https://customer.umico.az"
    }

    @GET("$URL_CUSTOMER/v2/clients/account/sign-in")
    suspend fun enterViaPhone(@Query("phone") phone: String)

    @POST("$URL_CUSTOMER/v2/clients/account/sign-in")
    suspend fun checkOtpAndConfirm(@Body otpCode: OtpCodeRequest): AccessTokenResponse
}