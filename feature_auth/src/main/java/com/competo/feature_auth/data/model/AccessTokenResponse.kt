package com.competo.feature_auth.data.model

import com.google.gson.annotations.SerializedName

data class AccessTokenResponse(
    @SerializedName("access_token")
    var accessToken: String?,
    @SerializedName("expires_in")
    var expiresIn: Int?,
    @SerializedName("refresh_expires_in")
    var refreshExpiresIn: Int?,
    @SerializedName("refresh_token")
    var refreshToken: String?,
    @SerializedName("token_type")
    var tokenType: String?,
    @SerializedName("not-before-policy")
    var notBeforePolicy: Int?,
    @SerializedName("session_state")
    var sessionState: String?,
    @SerializedName("scope")
    var scope: String?,
    @SerializedName("first_name")
    var firstName: String?,
    @SerializedName("active")
    var active: Boolean? = null,
    @SerializedName("ext_id")
    var extId: String? = null
)