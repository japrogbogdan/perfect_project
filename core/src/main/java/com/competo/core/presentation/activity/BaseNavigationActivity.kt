package com.competo.core.presentation.activity

import androidx.databinding.ViewDataBinding
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.competo.core.presentation.navigation.DirectionNavigator

//TODO Base Activity with NavController
abstract class BaseNavActivity<B : ViewDataBinding> : BaseActivity<B>() {

    protected abstract fun getNavHostFragmentId(): Int

    private val navController: NavController by lazy {
        findNavController(getNavHostFragmentId())
    }

    fun navigateTo(navigation: DirectionNavigator) {
        navigation.navigate { fragmentDestinationId, bundle ->
            navController.navigate(fragmentDestinationId, bundle)
        }
    }
}