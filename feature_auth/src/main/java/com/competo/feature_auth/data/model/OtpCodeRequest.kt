package com.competo.feature_auth.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by rmammadov on 4/2/19.
 */

data class OtpCodeRequest(
    @SerializedName("otp_code")
    var otpCode: String,
    @SerializedName("phone")
    var phone: String? = ""
)