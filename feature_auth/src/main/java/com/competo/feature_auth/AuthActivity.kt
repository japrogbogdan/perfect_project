package com.competo.feature_auth

import android.os.Bundle
import android.os.PersistableBundle
import com.competo.core.presentation.activity.BaseNavActivity
import com.competo.feature_auth.databinding.AuthActivityLayoutBinding

class AuthActivity : BaseNavActivity<AuthActivityLayoutBinding>(){

    override fun getLayoutRes(): Int = R.layout.auth_activity_layout

    override fun getNavHostFragmentId(): Int = R.id.feature_auth_nav_host_fragment

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }
}