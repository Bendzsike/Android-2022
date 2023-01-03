package com.example.tracker.ui.myTasks

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MyTasks(navController: NavController) {
    Column {
        Text(
            text = "MyTasks page",
            style = TextStyle(
                fontWeight = FontWeight(700),
                fontSize = 24.sp
            ),
            modifier = Modifier.align(Alignment.Start)
        )
    }
}