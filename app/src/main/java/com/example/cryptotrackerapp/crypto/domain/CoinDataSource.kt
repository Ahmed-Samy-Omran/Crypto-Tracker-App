package com.example.cryptotrackerapp.crypto.domain

import com.example.cryptotrackerapp.core.domain.util.NetworkError
import com.example.cryptotrackerapp.core.domain.util.Result
import java.time.ZonedDateTime

interface CoinDataSource {
    // in case of error return NetworkError, in case of success return list of Coin
    suspend fun getCoins():Result<List<Coin>, NetworkError>

    suspend fun getCoinHistory(
        coinId: String,
        start: ZonedDateTime,
        end: ZonedDateTime
    ):Result<List<CoinPrice>, NetworkError>
}