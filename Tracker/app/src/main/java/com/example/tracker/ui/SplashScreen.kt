package com.example.tracker.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tracker.R
import com.example.tracker.navigation.Routes

@Composable
fun SplashScreen(navController: NavController) {
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

    //TODO: Check if logged in, if yes, redirect to HomePage
    if(true) {
        navController.navigate(Routes.LoginScreen.route)
    }
}