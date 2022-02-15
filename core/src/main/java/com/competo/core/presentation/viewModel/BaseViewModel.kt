package com.competo.core.presentation.viewModel

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.competo.core.presentation.SafeLiveEvent
import com.competo.core.presentation.navigation.FragmentDirection
import com.competo.core.presentation.navigation.Navigator
import com.hadilq.liveevent.LiveEvent
import kotlinx.coroutines.CoroutineExceptionHandler
import org.koin.core.component.KoinComponent
import retrofit2.HttpException
import java.net.ConnectException

abstract class BaseViewModel : ViewModel(), KoinComponent {

    private val _navigateLiveEvent: SafeLiveEvent<FragmentDirection> = SafeLiveEvent()
    private val _navigateBackLiveEvent: SafeLiveEvent<Pair<String, Bundle>> = SafeLiveEvent()
    private val _hideKeyboard: LiveEvent<Boolean> = LiveEvent()

    val navigateLiveEvent: LiveData<FragmentDirection> = _navigateLiveEvent
    val navigateBackLiveEvent: SafeLiveEvent<Pair<String, Bundle>> = _navigateBackLiveEvent
    val hideKeyboard: LiveData<Boolean> = _hideKeyboard

    //keep here to test common error handler logic
    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        val defaultErrorMsg = "Something went wrong"
        val errorMsg = when (throwable) {
            is ConnectException -> ""
            is HttpException -> ""
            else -> defaultErrorMsg
        }

        Log.d("ExceptionHandler", errorMsg)
    }

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