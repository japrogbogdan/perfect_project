package com.competo.core.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.competo.core.presentation.viewModel.BaseViewModel
import com.competo.core.presentation.viewModel.BaseViewModelFragment

abstract class BaseBindingFragment<B : ViewDataBinding, VM : BaseViewModel> :
    BaseViewModelFragment<VM>() {

    private var _binding: B? = null

    /**
     * This property is only valid between onCreateView and onDestroyView.
     *
     * @see <a href="ttps://developer.android.com/topic/libraries/view-binding#fragments">android docs</a>
     */
    protected val binding get() = _binding!!

    abstract fun bindingViewModelEqualViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false)
        binding.lifecycleOwner = this
        bindingViewModelEqualViewModel()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}