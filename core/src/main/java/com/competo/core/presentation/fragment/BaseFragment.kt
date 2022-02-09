package com.competo.core.presentation.fragment

import android.os.Parcelable
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.competo.core.presentation.activity.BaseActivity

//TODO Base Fragment for all fragments in application
abstract class BaseFragment : Fragment() {

    companion object {
        private const val DEFAULT_TIME_DELAY = 130L
        private const val DELAY_KEYBOARD_HIDE = 200L
    }

    @LayoutRes
    abstract fun getLayoutRes(): Int

    protected fun getBooleanExtra(extra: String, def: Boolean = false): Boolean =
        arguments?.getBoolean(extra, def) ?: def

    protected fun getStringExtra(extra: String, def: String = ""): String =
        arguments?.getString(extra) ?: def

    protected fun getIntExtra(extra: String, def: Int = 0): Int =
        arguments?.getInt(extra, def) ?: def

    protected fun getLongExtra(extra: String, def: Long = 0): Long =
        arguments?.getLong(extra, def) ?: def

    @Suppress("UNCHECKED_CAST")
    protected fun <T> getExtra(extra: String): T? = arguments?.getSerializable(extra) as? T

    @Suppress("UNCHECKED_CAST")
    protected fun <T : Parcelable> getParcelableExtra(extra: String): T? =
        arguments?.getParcelable(extra)

    @Suppress("UNCHECKED_CAST")
    protected fun <T : Parcelable> getParcelableArrayList(extra: String): ArrayList<T>? =
        arguments?.getParcelableArrayList(extra)


    private fun requireBaseActivity() = requireActivity() as BaseActivity<*>

}