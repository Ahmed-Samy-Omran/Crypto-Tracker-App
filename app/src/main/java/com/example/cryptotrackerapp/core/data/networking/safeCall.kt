package com.example.cryptotrackerapp.core.data.networking

import com.example.cryptotrackerapp.core.domain.util.NetworkError
import io.ktor.client.statement.HttpResponse
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.coroutines.ensureActive
import kotlinx.serialization.SerializationException
import kotlin.Result
import kotlin.coroutines.coroutineContext

suspend inline fun <reified T> safeCall(
    execute: () -> HttpResponse
): com.example.cryptotrackerapp.core.domain.util.Result<T, NetworkError> {
    val response = try {
        execute()
    } catch(e: UnresolvedAddressException) {
        return com.example.cryptotrackerapp.core.domain.util.Result.Error(NetworkError.NO_INTERNET)
    } catch(e: SerializationException) {
        return com.example.cryptotrackerapp.core.domain.util.Result.Error(NetworkError.SERIALIZATION)
    } catch(e: Exception) {
        coroutineContext.ensureActive()
        return com.example.cryptotrackerapp.core.domain.util.Result.Error(NetworkError.UNKNOWN)
    }

    return responseToResult(response)
}