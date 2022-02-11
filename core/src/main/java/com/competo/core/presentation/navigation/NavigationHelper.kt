package com.competo.core.presentation.navigation

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

fun navigate(activity: Activity?, navigation: ActivityDestinationFragment) {
    if (activity == null) return

    val intent = Intent().setClassName(activity, navigation.activityClassName)
    navigation.modifyIntent(intent)
    activity.startActivity(intent)
}

inline fun <reified A : AppCompatActivity> Activity?.navigate(modifyIntent: (Intent) -> Unit = {}) {
    if (this == null) return

    val intent = Intent(this, A::class.java)
    modifyIntent(intent)
    this.startActivity(intent)
}


