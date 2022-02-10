package com.competo.navigation.navigation.base

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.competo.core.presentation.navigation.INavigatorNavigable

open class MultiBackStackNavigation : INavigatorNavigable {

    override fun navigate(
        navController: NavController,
        fromActivity: AppCompatActivity,
        fromFragment: Fragment?
    ) {
        TODO("Not yet implemented")
    }

}
