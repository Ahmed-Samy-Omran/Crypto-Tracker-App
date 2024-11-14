package com.example.cryptotrackerapp.crypto.data.networking.dto

import kotlinx.serialization.Serializable

@Serializable
// this is actual response that return from api
data class CoinsResponseDto(
    val data: List<CoinDto>
)
