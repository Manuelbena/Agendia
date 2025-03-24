package com.example.agendia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import com.example.agendia.navigation.NavigationHost
import com.example.agendia.navigation.NavigationRoute
import com.example.agendia.ui.theme.AgendiaTheme
import com.example.agendia.ui.theme.BackgroundPrimary
import dagger.hilt.android.AndroidEntryPoint
import java.lang.reflect.Modifier


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            AgendiaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = BackgroundPrimary
                ) {
                    val startDestination = NavigationRoute.LoginScreen

                    NavigationHost(startDestination)
                }

            }
        }
    }
}

