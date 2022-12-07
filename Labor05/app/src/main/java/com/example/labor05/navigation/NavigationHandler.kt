package com.example.labor05.navigation

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.labor05.ui.quiztime.EndScreen
import com.example.labor05.ui.quiztime.MainScreen
import com.example.labor05.ui.quiztime.QuestionScreen
import com.example.labor05.utilities.questionListSetup

@Composable
fun NavigationHandler(){
    val context = LocalContext.current
    val navController = rememberNavController()

    val questions = questionListSetup()

    val startDestination = Routes.MainScreen.route

    NavHost(navController = navController, startDestination = startDestination) {

        composable(Routes.MainScreen.route) {
            BackHandler(true) {
                Toast.makeText(context, "Shame.", Toast.LENGTH_LONG).show()
            }
            MainScreen(navController = navController)
        }

        composable(
            "${Routes.QuestionScreen.route}/{questionNumber}/{correctAnswers}/{name}",
            arguments = listOf(
                navArgument("questionNumber") { type = NavType.IntType },
                navArgument("correctAnswers") { type = NavType.IntType },
                navArgument("name") { type = NavType.StringType }
            )
        ) {
            val number = it.arguments?.getInt("questionNumber") ?: 0
            val correctAnswers = it.arguments?.getInt("correctAnswers") ?: 0
            val name = it.arguments?.getString("name") ?: ""

            BackHandler(true) {
                Toast.makeText(context, "Shame.", Toast.LENGTH_LONG).show()
            }

            QuestionScreen(navController = navController, questions, number, correctAnswers, name)
        }

        composable(
            "${Routes.EndScreen.route}/{correctAnswers}/{allAnswers}/{name}",
            arguments = listOf(
                navArgument("correctAnswers") { type = NavType.IntType },
                navArgument("allAnswers") { type = NavType.IntType },
                navArgument("name") { type = NavType.StringType }
            )
        ) {
            val correctAnswers = it.arguments?.getInt("correctAnswers") ?: 0
            val allAnswers = it.arguments?.getInt("allAnswers") ?: 0
            val name = it.arguments?.getString("name") ?: ""

            BackHandler(true) {
                Toast.makeText(context, "Shame.", Toast.LENGTH_LONG).show()
            }

            EndScreen(navController = navController, correctAnswers, allAnswers, name)
        }
    }
}