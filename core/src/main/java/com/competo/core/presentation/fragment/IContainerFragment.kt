package com.competo.core.presentation.fragment

interface IContainerFragment {

    fun navigateFromChildFragment(childFragment: BaseFragment): Boolean
}