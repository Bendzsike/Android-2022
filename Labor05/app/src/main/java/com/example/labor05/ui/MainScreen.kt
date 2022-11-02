package com.example.labor05.ui

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.labor05.Routes

@Composable
fun MainScreen(navController: NavController) {
    val focusManager = LocalFocusManager.current
    val context = LocalContext.current

    var name by remember { mutableStateOf("") }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "QUIZ",
            style = TextStyle(fontSize = 26.sp),
        )
        Spacer(Modifier.size(70.dp))
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(text = "Name") },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent
            )
        )
        Spacer(Modifier.size(70.dp))
        Button(
            onClick = {
                if(name == "") {
                    Toast.makeText(context, "Please enter your name!", Toast.LENGTH_SHORT).show()
                } else {
                    navController.navigate("${Routes.QuestionScreen.route}/0/0/$name")
                }
            }
        ) {
            Text(text = "Get Started")
        }
    }
}