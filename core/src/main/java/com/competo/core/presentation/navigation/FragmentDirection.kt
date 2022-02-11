package com.competo.core.presentation.navigation

import android.os.Bundle

interface FragmentDirection: Navigator {

    fun navigate(body: (fragmentDestinationId: Int, bundle: Bundle) -> Unit)
}
