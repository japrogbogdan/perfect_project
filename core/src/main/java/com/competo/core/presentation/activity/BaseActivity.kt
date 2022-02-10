package com.competo.core.presentation.activity

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.competo.core.presentation.navigation.IActivityNavigable
import com.competo.core.presentation.navigation.INavigable
import com.competo.core.presentation.navigation.navigate
import com.competo.core.presentation.extensions.updateConfigurationIfSupported

abstract class BaseActivity <V : ViewDataBinding> : AppCompatActivity()  {

    protected lateinit var binding: V

    @LayoutRes
    abstract fun getLayoutRes(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayoutRes())
        binding.lifecycleOwner = this
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        applyOverrideConfiguration(updateConfigurationIfSupported())
    }

    open fun navigateTo(navigation: INavigable, fragment: Fragment?) {
        if (navigation is IActivityNavigable) {
            navigate(this, navigation)
        } else {
            Toast.makeText(
                this,
                navigation::class.java.simpleName + "navigation not implemented",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}