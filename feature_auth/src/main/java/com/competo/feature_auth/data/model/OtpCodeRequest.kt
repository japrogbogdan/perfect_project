package com.competo.feature_auth.data.model

import com.google.gson.annotations.SerializedName

data class OtpCodeRequest(

    @SerializedName("otp_code")
    var otpCode: String,
    @SerializedName("phone")
    var phone: String? = ""
)