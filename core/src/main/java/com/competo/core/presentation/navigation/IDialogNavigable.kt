package com.competo.core.presentation.navigation

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.viewbinding.ViewBinding
import com.competo.core.presentation.activity.BaseNavActivity

interface IDialogNavigable : INavigable {

    fun <B : ViewBinding> navigate(
        navController: NavController,
        activity: BaseNavActivity<B>,
        fragment: Fragment?
    )
}

