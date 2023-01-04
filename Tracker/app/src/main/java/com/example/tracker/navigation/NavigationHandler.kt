package com.example.tracker.navigation

import android.content.SharedPreferences
import android.os.Build
import androidx.activity.compose.BackHandler
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tracker.ui.LoginScreen
import com.example.tracker.ui.SplashScreen
import com.example.tracker.ui.myTasks.CreateTask
import com.example.tracker.ui.myTasks.DetailedTaskInterface
import com.example.tracker.ui.myTasks.MyTasks
import com.example.tracker.ui.profile.Profile

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun NavigationHandler(sharedPreferences: SharedPreferences){

    val navController = rememberNavController()

    val startDestination = Routes.SplashScreen.route

    NavHost(navController = navController, startDestination = startDestination) {

        composable(Routes.SplashScreen.route) {
            BackHandler(true) {}
            SplashScreen(navController = navController, sharedPreferences = sharedPreferences)
        }

        composable(Routes.LoginScreen.route) {
            BackHandler(true) {}
            LoginScreen(navController = navController, sharedPreferences = sharedPreferences)
        }

        composable(Routes.MyTasks.route) {
            BackHandler(true) {}
            MyTasks(navController = navController, sharedPreferences = sharedPreferences)
        }

        composable(Routes.Profile.route) {
            BackHandler(true) {}
            Profile(navController = navController, sharedPreferences = sharedPreferences)
        }

        composable(
            "${Routes.DetailedTask.route}/{taskId}",
            arguments = listOf(
                navArgument("taskId") { type = NavType.IntType }
            )
        ) {
            val taskId = it.arguments?.getInt("taskId") ?: 0

            DetailedTaskInterface(navController = navController, taskId, sharedPreferences = sharedPreferences)
        }

        composable(Routes.CreateTask.route) {
            BackHandler(true) {}
            CreateTask(navController = navController, sharedPreferences = sharedPreferences)
        }
    }
}