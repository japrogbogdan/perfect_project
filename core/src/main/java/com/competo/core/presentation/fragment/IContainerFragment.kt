package com.competo.core.presentation.fragment

import com.competo.core.presentation.navigation.INavigable

interface IContainerFragment {

    fun navigateFromChildFragment(childFragment: BaseFragment, navigation: INavigable): Boolean
}