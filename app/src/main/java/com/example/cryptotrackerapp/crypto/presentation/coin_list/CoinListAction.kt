package com.example.cryptotrackerapp.crypto.presentation.coin_list

import com.example.cryptotrackerapp.crypto.presentation.models.CoinUi

sealed interface CoinListAction {
    // when i click on coin i show coin screen
    data class OnCoinClick(
    val coinUi: CoinUi
    ): CoinListAction

}