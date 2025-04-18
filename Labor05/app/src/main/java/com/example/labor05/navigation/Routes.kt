package com.example.labor05.navigation

sealed class Routes(val route: String) {
    object MainScreen : Routes("MainScreen")
    object QuestionScreen : Routes("QuestionScreen")
    object EndScreen : Routes("EndScreen")
}