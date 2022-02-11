package com.competo.core.presentation.activity

import android.content.Context
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.competo.core.presentation.extensions.updateConfigurationIfSupported

abstract class BaseActivity<V : ViewDataBinding>(@LayoutRes private val layoutRes: Int) : AppCompatActivity() {

    protected lateinit var binding: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutRes)
        binding.lifecycleOwner = this
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        applyOverrideConfiguration(updateConfigurationIfSupported())
    }
}