package com.competo.core.presentation.viewModel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.competo.core.presentation.SafeLiveEvent
import com.competo.core.presentation.activity.BaseActivity
import com.competo.core.presentation.navigation.FragmentDirection
import com.competo.core.presentation.navigation.Navigator
import com.hadilq.liveevent.LiveEvent
import org.koin.core.component.KoinComponent

abstract class BaseViewModel : ViewModel(), KoinComponent {

    private val _navigateLiveEvent: SafeLiveEvent<FragmentDirection> = SafeLiveEvent()
    private val _navigateBackLiveEvent: SafeLiveEvent<Pair<String, Bundle>> = SafeLiveEvent()
    private val _hideKeyboard: LiveEvent<Boolean> = LiveEvent()

    val navigateLiveEvent: LiveData<FragmentDirection> = _navigateLiveEvent
    val navigateBackLiveEvent: SafeLiveEvent<Pair<String, Bundle>> = _navigateBackLiveEvent
    val hideKeyboard: LiveData<Boolean> = _hideKeyboard

    protected abstract val navigator: Navigator

    fun navigate(activity: AppCompatActivity? = null, fragmentDirection: FragmentDirection) {
        hideKeyboard()
        _navigateLiveEvent.postValue(fragmentDirection)
    }

    fun hideKeyboard() {
        _hideKeyboard.postValue(true)
    }

    fun navigateBack(withResult: Pair<String, Bundle> = Pair("", bundleOf())) {
        hideKeyboard()
        _navigateBackLiveEvent.postValue(withResult)
    }
}