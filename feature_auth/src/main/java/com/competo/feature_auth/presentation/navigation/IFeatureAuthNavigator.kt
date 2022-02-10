package com.competo.feature_auth.presentation.navigation

import com.competo.core.presentation.navigation.INavigator

interface IFeatureAuthNavigator : INavigator {

    fun openOtpCode(phoneNumber: String)

}