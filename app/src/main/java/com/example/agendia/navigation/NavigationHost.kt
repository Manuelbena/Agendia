package com.example.agendia.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.agendia.authentication.presentation.LoginScreen
import com.example.agendia.home.Presentation.HomeScreen

@Composable
fun NavigationHost(
    startDestination: NavigationRoute
) {
    val navHostController = rememberNavController()

    NavHost(
        navController = navHostController,
        startDestination = startDestination.route
    ) {
        composable(NavigationRoute.LoginScreen.route) {
            LoginScreen()
        }
        composable(NavigationRoute.HomeScreen.route) {
           HomeScreen()

        }
    }


}