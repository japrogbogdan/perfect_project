package com.competo.core.data.exception

class InvalidServerResponseException(message: String) : Exception() {

    override val message: String? = "INVALID RESPONSE: $message"
}