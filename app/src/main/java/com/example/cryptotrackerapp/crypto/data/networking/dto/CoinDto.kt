package com.example.cryptotrackerapp.crypto.data.networking.dto

import kotlinx.serialization.Serializable

@Serializable
// that contain all details come from api
data class CoinDto(
    val id: String,
    val rank: Int,
    val name: String,
    val symbol: String,
    val marketCapUsd: Double,
    val priceUsd: Double,
    val changePercent24Hr: Double
)
