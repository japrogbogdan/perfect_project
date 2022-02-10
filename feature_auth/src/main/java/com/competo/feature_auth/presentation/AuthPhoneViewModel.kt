package com.competo.feature_auth.presentation

class AuthPhoneViewModel : BaseAuthViewModel(){

    fun navigateToOtp(phoneNumber: String){
        navigator.openOtpCode(phoneNumber)
    }
}