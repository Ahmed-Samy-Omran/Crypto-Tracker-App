package com.example.cryptotrackerapp.crypto.presentation.coin_list

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import com.example.cryptotrackerapp.core.presentation.util.toString
import com.example.cryptotrackerapp.crypto.presentation.coin_list.components.CoinListItem
import com.example.cryptotrackerapp.crypto.presentation.coin_list.components.previewCoin
import com.example.cryptotrackerapp.ui.theme.CryptoTrackerTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.withContext

@Composable
fun CoinListScreen(
    modifier: Modifier = Modifier,
    state: CoinListState
) {


    if (state.isLoading) {
        Box(modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
            ) {
            CircularProgressIndicator()
        }
    }else{
        LazyColumn (
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ){
            items(state.coins) { coinUi->
                CoinListItem(coinUi = coinUi,
                    onClick = { /*TODO*/ },
                    modifier = Modifier.fillMaxSize()
                )
                HorizontalDivider()
            }


            }
        }
    }




@PreviewLightDark
@Composable
private fun CoinListScreenPreview() {
    CryptoTrackerTheme {
        CoinListScreen(
            state = CoinListState(
                coins = (1..100).map { previewCoin.copy(id = it.toString()) },
            ),

            modifier = Modifier.background(
                MaterialTheme.colorScheme.background
            )
        )
    }
}


