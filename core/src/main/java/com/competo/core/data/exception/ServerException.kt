package com.competo.core.data.exception

import okhttp3.Response

class ServerException(val code: Int, val errorMessage: String?, val response: Response? = null) :
    Throwable()

