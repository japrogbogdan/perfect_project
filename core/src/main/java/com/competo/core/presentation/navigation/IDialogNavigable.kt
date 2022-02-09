package com.competo.core.presentation.navigation

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.competo.core.presentation.activity.BaseNavActivity

interface IDialogNavigable : INavigable {

    fun <B : ViewDataBinding> navigate(
        navController: NavController,
        activity: BaseNavActivity<B>,
        fragment: Fragment?
    )
}

