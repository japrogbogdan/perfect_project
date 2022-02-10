package com.competo.core.presentation.navigation

import android.os.Bundle

interface DirectionNavigator: Navigator {

    fun navigate(body: (fragmentDestinationId: Int, bundle: Bundle) -> Unit)
}
