package com.example.tracker.ui

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tracker.R
import com.example.tracker.navigation.Routes
import com.example.tracker.repo.UserRepository
import com.example.tracker.ui.groups.getDepartments
import com.example.tracker.ui.myTasks.getMyTasks
import com.example.tracker.ui.users.getAllUsers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

private val userRepo = UserRepository()

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SplashScreen(navController: NavController, sharedPreferences: SharedPreferences) {
    Box {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "background",
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .fillMaxSize()
        )
    }
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.track_logo),
            contentDescription = "logo",
            modifier = Modifier.fillMaxSize(0.5f)
        )
        Spacer(Modifier.size(50.dp))
    }

    val token = sharedPreferences.getString("token", "").toString()
    val deadline : Long = sharedPreferences.getLong("deadline", 0)

    var hasNavigated by rememberSaveable { mutableStateOf(false) }
    if(!hasNavigated) {
        if(System.currentTimeMillis() < deadline) {
            CoroutineScope(IO).launch {
                try {
                    val response = userRepo.getCurrentUser(token)
                    if (response?.isSuccessful == true) {
                        withContext(Dispatchers.Main) {
                            getMyTasks(token)
                            getDepartments(token)
                            getAllUsers(token)
                            navController.navigate(Routes.MyTasks.route)
                            hasNavigated = true
                        }
                    } else {
                        withContext(Dispatchers.Main) {
                            navController.navigate(Routes.LoginScreen.route)
                            hasNavigated = true
                        }
                    }
                } catch (ex: Exception) {
                    Log.e("getCurrentUser", ex.message, ex)
                }
            }
        } else {
            navController.navigate(Routes.LoginScreen.route)
            hasNavigated = true
        }
    }
}