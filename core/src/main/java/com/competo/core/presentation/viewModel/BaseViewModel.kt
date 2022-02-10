package com.competo.core.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.competo.core.presentation.SafeLiveEvent
import com.competo.core.presentation.navigation.INavigable
import com.competo.core.presentation.navigation.INavigator
import com.hadilq.liveevent.LiveEvent
import org.koin.core.component.KoinComponent

abstract class BaseViewModel : ViewModel(), KoinComponent {

    private val _navigateLiveEvent: SafeLiveEvent<INavigable> = SafeLiveEvent()
    private val _hideKeyboard: LiveEvent<Boolean> = LiveEvent()

    protected abstract val navigator: INavigator

    val navigateLiveEvent: LiveData<INavigable> = _navigateLiveEvent
    val hideKeyboard: LiveData<Boolean> = _hideKeyboard

    fun navigate(target: INavigable){
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