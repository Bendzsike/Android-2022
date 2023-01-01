package com.example.tracker.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tracker.ui.LoginScreen
import com.example.tracker.ui.SplashScreen

@Composable
fun NavigationHandler(){

    val navController = rememberNavController()

    val startDestination = Routes.SplashScreen.route

    NavHost(navController = navController, startDestination = startDestination) {

        composable(Routes.SplashScreen.route) {
            BackHandler(true) {}
            SplashScreen(navController = navController)
        }

        composable(Routes.LoginScreen.route) {
            BackHandler(true) {}
            LoginScreen(navController = navController)
        }
    }
}