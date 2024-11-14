package com.example.cryptotrackerapp.core.data.networking

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.ANDROID
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object HttpClientFactory {
        //HttpClientEngine as a parameter, allowing you to pass in different engines (e.g., CIO, OkHttp)
    fun create(engine: HttpClientEngine): HttpClient {
        return HttpClient(engine) {
            // 1. Logging configuration
            install(Logging) {
                level = LogLevel.ALL // Sets the logging level to ALL, so all details (headers, body, status) of the HTTP requests and responses are logged
                logger = Logger.ANDROID // This is specifically useful in Android environments to see logs in the Logcat.
            }

            // 2. Content negotiation with JSON
            install(ContentNegotiation) {
                json(
                    json = Json {
                        ignoreUnknownKeys = true // Configures the JSON parser to ignore any unexpected
                                                    // fields in JSON responses. This is useful when dealing
                                            // with APIs that may return extra fields that aren’t part of your data classes
                                            // , preventing errors during deserialization.
                    }
                )
            }

            // 3. Default request configuration
            defaultRequest {
                contentType(ContentType.Application.Json) // Sets the default content type to JSON
            }
        }
    }
}