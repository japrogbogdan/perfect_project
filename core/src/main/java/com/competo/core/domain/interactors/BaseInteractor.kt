package com.competo.core.domain.interactors

open class BaseInteractor {

    sealed class Result<out T> {
        data class Success<out R>(val data: R) : Result<R>()
        data class Error(val error: Throwable) : Result<Nothing>()
    }

    suspend fun <T> makeApiRequest(
        apiRequestSuspended: suspend () -> T,
        success: (result: T) -> Unit = {},
        error: (exception: Throwable) -> Unit = {}
    ): Result<T> {
        return try {
            Result.Success(apiRequestSuspended.invoke())
        } catch (exception: Exception) {
            Result.Error(exception)
        }.wrap(success, error)
    }

    private fun <T> Result<T>.wrap(
        success: (result: T) -> Unit = {},
        error: (exception: Throwable) -> Unit = {}
    ): Result<T> = this.apply {
        when (this) {
            is Result.Success<T> -> success.invoke(this.data)
            is Result.Error -> error.invoke(this.error)
        }
    }
}