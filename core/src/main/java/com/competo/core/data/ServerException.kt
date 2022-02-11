package com.competo.core.data

import okhttp3.Response

class ServerException(val code: Int, val errorMessage: String?, val response: Response? = null) :
    Throwable()

