package com.example.tracker.ui

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tracker.R

@Composable
fun LoginScreen(navController: NavController) {
    val focusManager = LocalFocusManager.current
    val context = LocalContext.current

    var email by remember { mutableStateOf("") }

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
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.track_logo),
            contentDescription = "logo",
            modifier = Modifier.fillMaxSize(0.5f)
        )
        Box(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(bottom = 16.dp)
                .align(Alignment.CenterHorizontally)
                .background(Color.White.copy(0.1f))
                .clip(RoundedCornerShape(10.dp))

        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(10.dp))
                    .padding(35.dp)
            ) {
                Text(
                    text = "Hey, please log in",
                    style = TextStyle(
                        fontWeight = FontWeight(700),
                        fontSize = 24.sp
                    ),
                    modifier = Modifier.align(Alignment.Start)
                )
                Spacer(Modifier.size(70.dp))
                TextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text(text = "E-mail") },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { focusManager.clearFocus() }
                    ),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.White.copy(alpha = 0.3f)
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(Modifier.size(70.dp))
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.White,
                        contentColor = Color.Black
                    ),
                    onClick = {
                        if (email == "") {
                            Toast.makeText(context, "Please enter your e-mail!", Toast.LENGTH_SHORT).show()
                        } else {
                            //TODO: Actual login
                        }
                    }
                ) {
                    Text(
                        text = "Sign In",
                        style = TextStyle(
                            fontWeight = FontWeight(700)
                        )
                    )
                }
            }
        }
    }
}