package com.example.cryptotrackerapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.cryptotrackerapp.core.presentation.util.ObserveAsEvents
import com.example.cryptotrackerapp.core.presentation.util.toString
import com.example.cryptotrackerapp.crypto.presentation.coin_list.CoinListEvent
import com.example.cryptotrackerapp.crypto.presentation.coin_list.CoinListScreen
import com.example.cryptotrackerapp.crypto.presentation.coin_list.CoinListViewModel
import com.example.cryptotrackerapp.ui.theme.CryptoTrackerTheme
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CryptoTrackerTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) {innerPadding ->

                     val viewModel: CoinListViewModel by viewModel()
                     val state by viewModel.state.collectAsStateWithLifecycle()
                    val context = LocalContext.current
                    ObserveAsEvents(events =viewModel.events) {event->
                        when(event) {
                            is CoinListEvent.Error -> {
                               Toast.makeText(context, event.error.toString(context), Toast.LENGTH_LONG).show()
                            }
                        }

                    }
                    CoinListScreen(state = state,
                        modifier = Modifier.padding(innerPadding),
                        )
                }

            }
        }
    }
}

