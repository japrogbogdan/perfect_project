package com.competo.core.presentation.viewModel

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.competo.core.presentation.activity.BaseActivity
import com.competo.core.presentation.extensions.hideSoftKeyboardForView
import com.competo.core.presentation.fragment.BaseFragment
import com.competo.core.presentation.fragment.IContainerFragment
import com.competo.core.presentation.navigation.INavigable

abstract class BaseViewModelFragment<VM : BaseViewModel> : BaseFragment() {

    protected abstract val viewModel: VM // только эта вьюмодель будет навигацироваться. все остальные надо подписывать вручную

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.navigateLiveEvent.observe(viewLifecycleOwner, Observer { navigateTo(it) })
        viewModel.hideKeyboard.observe(viewLifecycleOwner, Observer {
            if (it) {
                activity?.currentFocus?.clearFocus()
                view.hideSoftKeyboardForView()
            }
        })
    }

    open fun navigateTo(navigation: INavigable) {
        val containerFragment = this as? IContainerFragment
        if (containerFragment?.navigateFromChildFragment(this, navigation) == true) {
            return
        }
        (activity as? BaseActivity<*>)?.navigateTo(navigation, this)
    }
}