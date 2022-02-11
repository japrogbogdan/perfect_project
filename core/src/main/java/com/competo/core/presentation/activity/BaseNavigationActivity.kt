package com.competo.core.presentation.activity

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.competo.core.presentation.navigation.DirectionNavigator

//TODO Base Activity with NavController
abstract class BaseNavActivity<B : ViewDataBinding>(@LayoutRes private val layoutRes: Int) : BaseActivity<B>(layoutRes) {

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