package com.example.labor05

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.labor05.ui.EndScreen
import com.example.labor05.ui.MainScreen
import com.example.labor05.ui.QuestionScreen
import com.example.labor05.ui.theme.Labor05Theme
import com.example.labor05.utilities.questionListSetup

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Labor05Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NavigationHandler()
                }
            }
        }
    }
}

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



