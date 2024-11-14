package com.example.cryptotrackerapp.core.domain.util

enum class NetworkError:Error {
                              // i put all error that can appear with network
    REQUEST_TIMEOUT,
    TOO_MANY_REQUESTS,
    NO_INTERNET,
    SERVER_ERROR,
    SERIALIZATION,
    UNKNOWN,
}