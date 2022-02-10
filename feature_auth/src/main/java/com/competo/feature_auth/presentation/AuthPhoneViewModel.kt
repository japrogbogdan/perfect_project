package com.competo.feature_auth.presentation

class AuthPhoneViewModel : BaseAuthViewModel(){


    fun sendPhone(phoneNumber: String){
        // request for phone
        // get answer and navigate
        navigator.openOtpCode(phoneNumber)

    }
}