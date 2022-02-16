package com.competo.core.data.exceptions

class InvalidServerResponseException(message: String) : Exception() {

    override val message: String? = "INVALID RESPONSE: $message"
}