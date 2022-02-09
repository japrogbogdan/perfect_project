package com.competo.core.presentation.activity

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.competo.core.presentation.navigation.IActivityNavigable
import com.competo.core.presentation.navigation.INavigable
import com.competo.core.presentation.navigation.navigate
import com.competo.core.presentation.extensions.updateConfigurationIfSupported

abstract class BaseActivity <V : ViewBinding> : AppCompatActivity()  {

    protected lateinit var binding: V

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        setContentView(binding.root)
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

    abstract fun getViewBinding(): V
}