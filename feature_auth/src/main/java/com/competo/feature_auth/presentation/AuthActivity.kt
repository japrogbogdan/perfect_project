package com.competo.feature_auth.presentation

import com.competo.core.presentation.activity.BaseNavActivity
import com.competo.feature_auth.R
import com.competo.feature_auth.databinding.AuthActivityLayoutBinding

class AuthActivity : BaseNavActivity<AuthActivityLayoutBinding>(R.layout.auth_activity_layout) {

    override fun getNavHostFragmentId(): Int = R.id.feature_auth_nav_host_fragment
}