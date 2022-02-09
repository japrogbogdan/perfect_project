package com.competo.core.presentation.navigation

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController

interface INavigatorNavigable : INavigable {

    fun navigate(
        navController: NavController,
        fromActivity: AppCompatActivity,
        fromFragment: Fragment?
    )
}
