package com.example.tracker.navigation

sealed class Routes(val route: String) {
    object SplashScreen : Routes("SplashScreen")
    object LoginScreen : Routes("LoginScreen")
    object MyTasks : Routes("MyTasks")
}