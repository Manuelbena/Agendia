package com.example.agendia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.agendia.navigation.NavigationHost
import com.example.agendia.navigation.NavigationRoute
import com.example.agendia.ui.theme.AgendiaTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AgendiaTheme {
                val startDestination = NavigationRoute.HomeScreen

                NavigationHost(startDestination)
            }
        }
    }
}

