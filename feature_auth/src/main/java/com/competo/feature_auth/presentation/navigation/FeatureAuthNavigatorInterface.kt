package com.competo.feature_auth.presentation.navigation

import com.competo.core.presentation.navigation.Navigator

interface FeatureAuthNavigatorInterface : Navigator {
    fun openOtpCode(phoneNumber: String)
}