package com.example.tracker.ui.myTasks

import android.content.SharedPreferences
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.tracker.ui.navigationBar.BottomNavigationBar
import com.example.tracker.ui.navigationBar.TopBar

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun DetailedTaskInterface(navController: NavController, taskId: Int, sharedPreferences: SharedPreferences) {

    Scaffold(
        backgroundColor = Color.White,
        topBar = { TopBar(title = "My Tasks", sharedPreferences) },
        bottomBar = { BottomNavigationBar(navController) }
    ) {
        val task: Task = getTaskById(taskId)!!
        TaskCard(task = task, navController = navController)
    }
}