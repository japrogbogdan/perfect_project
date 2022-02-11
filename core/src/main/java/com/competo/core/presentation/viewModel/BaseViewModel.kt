package com.competo.core.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.competo.core.presentation.SafeLiveEvent
import com.competo.core.presentation.navigation.DirectionNavigator
import com.competo.core.presentation.navigation.Navigator
import com.hadilq.liveevent.LiveEvent
import org.koin.core.component.KoinComponent

abstract class BaseViewModel : ViewModel(), KoinComponent {

    private val _navigateLiveEvent: SafeLiveEvent<DirectionNavigator> = SafeLiveEvent()
    private val _hideKeyboard: LiveEvent<Boolean> = LiveEvent()

    val navigateLiveEvent: LiveData<DirectionNavigator> = _navigateLiveEvent
    val hideKeyboard: LiveData<Boolean> = _hideKeyboard

    protected abstract val navigator: Navigator

    fun navigate(target: DirectionNavigator) {
        hideKeyboard()
        _navigateLiveEvent.postValue(target)
    }

    fun hideKeyboard() {
        _hideKeyboard.postValue(true)
    }

    open fun navigateBack() {
        hideKeyboard()
    }
}