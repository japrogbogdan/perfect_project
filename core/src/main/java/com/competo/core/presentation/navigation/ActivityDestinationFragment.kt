package com.competo.core.presentation.navigation

import android.content.Intent

//TODO Activity navigation interface
interface ActivityDestinationFragment : FragmentDirection {

    val activityClassName: String
    fun modifyIntent(intent: Intent) {}
}