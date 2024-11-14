package com.example.cryptotrackerapp.core.data.networking

import com.example.cryptotrackerapp.BuildConfig
import java.net.URL

fun constructUrl(url: String): String {
    return when {
        url.contains(BuildConfig.BASE_URL) -> url
        url.startsWith("/") -> BuildConfig.BASE_URL + url.drop(1)
        else -> BuildConfig.BASE_URL + url
    }
}