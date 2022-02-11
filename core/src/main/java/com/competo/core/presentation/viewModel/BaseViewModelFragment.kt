package com.competo.core.presentation.viewModel

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import com.competo.core.presentation.activity.BaseNavActivity
import com.competo.core.presentation.extensions.hideSoftKeyboardForView
import com.competo.core.presentation.fragment.BaseFragment
import com.competo.core.presentation.navigation.DirectionNavigator

abstract class BaseViewModelFragment<VM : BaseViewModel>(@LayoutRes private val layoutRes: Int) :
    BaseFragment(layoutRes) {

    protected abstract val viewModel: VM // только эта вьюмодель будет навигацироваться. все остальные надо подписывать вручную

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.navigateLiveEvent.observe(viewLifecycleOwner) { navigateTo(it) }
        viewModel.hideKeyboard.observe(viewLifecycleOwner) {
            if (it) {
                activity?.currentFocus?.clearFocus()
                view.hideSoftKeyboardForView()
            }
        }
    }

    open fun navigateTo(navigation: DirectionNavigator) {
        (activity as? BaseNavActivity<*>)?.navigateTo(navigation)
    }
}