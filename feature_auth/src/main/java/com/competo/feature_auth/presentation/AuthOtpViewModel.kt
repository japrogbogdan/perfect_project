package com.competo.feature_auth.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.competo.core.domain.interactors.BaseInteractor
import com.competo.core.presentation.SafeLiveEvent
import com.competo.core.presentation.viewModel.BaseViewModel
import com.competo.feature_auth.domain.entity.AccessToken
import com.competo.feature_auth.domain.interactors.AuthInteractor
import com.competo.feature_auth.presentation.navigation.FeatureAuthNavigatorInterface
import kotlinx.coroutines.launch
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf

class AuthOtpViewModel(private val interactor: AuthInteractor) : BaseViewModel() {

    private val _accessToken: SafeLiveEvent<AccessToken> = SafeLiveEvent()
    val accessToken: LiveData<AccessToken> = _accessToken

    override val navigator: FeatureAuthNavigatorInterface by inject { parametersOf(this) }

    fun get() {

        viewModelScope.launch {
            interactor.sentOtpCode(success = { accessToken ->
                launch { val temp = interactor.enterViaPhone() }
            })
        }

        // also can call request and get general Result
        viewModelScope.launch {
            when (val result = interactor.sentOtpCode()) {
                is BaseInteractor.Result.Success<AccessToken> -> {
                    result.data
                    _accessToken.postValue(result.data)
                }
                is BaseInteractor.Result.Error -> {
                    null
                }
            }
        }
    }
}