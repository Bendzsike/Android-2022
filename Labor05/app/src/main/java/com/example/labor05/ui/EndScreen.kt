package com.example.labor05.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.labor05.Routes
import com.example.labor05.R

@Composable
fun EndScreen(navController: NavController, correctAnswers: Int, allAnswers: Int, name: String) {
    val value = correctAnswers / allAnswers.toFloat()
    val firstText = stringResource(id =
    if (value == 0f) {
        R.string.none_correct
    } else if (value < 0.5f) {
        R.string.less_than_half_correct
    } else if (value == 0.5f) {
        R.string.half_correct
    } else if (value > 0.5f && value != 1f) {
        R.string.more_than_half_correct
    } else {
        R.string.all_correct
    }, name)

    val secondText = stringResource(id = R.string.score, correctAnswers, allAnswers)

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        Text(
            text = firstText,
            style = TextStyle(fontSize = 26.sp),
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.size(70.dp))
        Text(
            text = secondText,
            style = TextStyle(fontSize = 26.sp),
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.size(70.dp))
        Button(
            onClick = {
                navController.navigate(Routes.MainScreen.route)
            }
        ) {
            Text(text = "Back to Start")
        }
    }
}