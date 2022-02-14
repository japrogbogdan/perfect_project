package com.competo.core.data.mapper

import com.competo.core.data.exception.InvalidServerResponseException
import kotlin.reflect.KProperty1

open class BaseMapper<T : Any>(protected var response: T?) {

    protected fun validateNullOrEmpty(property: KProperty1<T, String?>): String {
        checkResponseNonNull()
        val value = property.get(response!!)
        if (value.isNullOrEmpty()) {
            throw createException("${property.name} is null or empty")
        } else {
            return value
        }
    }

    protected fun validateNull(property: T?): T {
        return property?.let {
            property
        } ?: run {
            throw InvalidServerResponseException("null ${property.toString()} value")
        }
    }

    protected fun validateAnyNull(any: Any?): Any {
        return any?.let {
            any
        } ?: run {
            throw InvalidServerResponseException("null ${any.toString()} value")
        }
    }

    protected fun validateNullOrEmpty(
        property: KProperty1<T, Map<String, String>?>,
        key: String
    ): String {
        checkResponseNonNull()
        val value = property.get(response!!)
        if (value.isNullOrEmpty() || value[key].isNullOrEmpty()) {
            throw createException("$key is null or empty")
        } else {
            return value.getValue(key)
        }
    }

    protected fun validateNull(property: KProperty1<T, Int?>): Int {
        checkResponseNonNull()
        val value = property.get(response!!)
        if (value == null) {
            throw createException("${property.name} is null")
        } else {
            return value
        }
    }

    protected fun validateNull(property: KProperty1<T, Long?>): Long {
        checkResponseNonNull()
        val value = property.get(response!!)
        if (value == null) {
            throw createException("${property.name} is null")
        } else {
            return value
        }
    }

    protected fun validateNull(property: KProperty1<T, Boolean?>): Boolean {
        checkResponseNonNull()
        val value = property.get(response!!)
        if (value == null) {
            throw createException("${property.name} is null")
        } else {
            return value
        }
    }

    protected fun validateNull(property: KProperty1<T, Any?>): Any {
        checkResponseNonNull()
        val value = property.get(response!!)
        if (value == null) {
            throw createException("${property.name} is null")
        } else {
            return value
        }
    }

    protected fun createException(message: String): InvalidServerResponseException {
        checkResponseNonNull()
        val exception = InvalidServerResponseException("${response!!::class.simpleName}: $message")
        return exception
    }

    protected fun checkResponseNonNull() {
        if (response == null) {
            throw InvalidServerResponseException("response is null")
        }
    }

    protected fun validateNullOrEmpty(value: String?, name: String): String {
        checkResponseNonNull()
        if (value.isNullOrEmpty()) {
            throw createException("$name is null or empty")
        } else {
            return value
        }
    }
}