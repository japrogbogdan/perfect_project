package com.competo.core.presentation.activity

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.viewbinding.ViewBinding
import com.competo.core.presentation.navigation.IDialogNavigable
import com.competo.core.presentation.navigation.INavigable
import com.competo.core.presentation.navigation.INavigatorNavigable

//TODO Base Activity with NavController
abstract class BaseNavActivity<B : ViewBinding> : BaseActivity<B>() {

    protected abstract fun getNavHostFragmentId(): Int

    protected val navController: NavController by lazy {
        findNavController(getNavHostFragmentId())
    }

    override fun navigateTo(navigation: INavigable, fragment: Fragment?) {
        when (navigation) {
            is INavigatorNavigable -> navigation.navigate(
                findNavController(getNavHostFragmentId()),
                this,
                fragment
            )
            is IDialogNavigable -> navigation.navigate(
                findNavController(getNavHostFragmentId()),
                this,
                fragment
            )
            else -> super.navigateTo(navigation, fragment)
        }
    }
}