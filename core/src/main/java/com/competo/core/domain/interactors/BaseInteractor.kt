package com.competo.core.domain.interactors

open class BaseInteractor {

    suspend fun <T> makeApiRequest(apiRequestSuspended: suspend () -> T): Result<T> {
        return try {
            Result.Success(apiRequestSuspended.invoke())
        } catch (exception: Exception) {
            Result.Error(exception)
        }
    }

    sealed class Result<out T> {
        data class Success<out R>(val data: R) : Result<R>()
        data class Error(val e: Throwable) : Result<Nothing>()
    }
}