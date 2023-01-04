package com.example.tracker.ui.myTasks

import android.content.SharedPreferences
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tracker.navigation.Routes
import com.example.tracker.ui.navigationBar.BottomNavigationBar
import com.example.tracker.ui.navigationBar.TopBar

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun CreateTask(navController: NavController, sharedPreferences: SharedPreferences) {
    val focusManager = LocalFocusManager.current
    val localContext = LocalContext.current
    var title by rememberSaveable { mutableStateOf("") }
    var description by rememberSaveable { mutableStateOf("") }
    var assignedTo by rememberSaveable { mutableStateOf("") }
    var priority by rememberSaveable { mutableStateOf("") }
    var deadline by rememberSaveable { mutableStateOf("") }
    var departmentId by rememberSaveable { mutableStateOf("") }
    var status by rememberSaveable { mutableStateOf("") }

    val token = sharedPreferences.getString("token", "")


    Scaffold(
        backgroundColor = Color.White,
        topBar = { TopBar(title = "My Tasks", sharedPreferences) },
        bottomBar = { BottomNavigationBar(navController) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth(0.9f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = title,
                onValueChange = { title = it },
                label = { Text(text = "Title") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Down) }
                ),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.DarkGray,
                    textColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.size(30.dp))

            TextField(
                value = description,
                onValueChange = { description = it },
                label = { Text(text = "Description") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Down) }
                ),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.DarkGray,
                    textColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.size(30.dp))

            TextField(
                value = assignedTo,
                onValueChange = { assignedTo = it },
                label = { Text(text = "Assigned To User") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Down) }
                ),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.DarkGray,
                    textColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.size(30.dp))

            TextField(
                value = priority,
                onValueChange = { priority = it },
                label = { Text(text = "Priority") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Down) }
                ),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.DarkGray,
                    textColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.size(30.dp))

            TextField(
                value = deadline,
                onValueChange = { deadline = it },
                label = { Text(text = "Deadline") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Down) }
                ),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.DarkGray,
                    textColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.size(30.dp))

            TextField(
                value = departmentId,
                onValueChange = { departmentId = it },
                label = { Text(text = "Department ID") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Down) }
                ),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.DarkGray,
                    textColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.size(30.dp))

            TextField(
                value = status,
                onValueChange = { status = it },
                label = { Text(text = "Status") },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = { focusManager.clearFocus() }
                ),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.DarkGray,
                    textColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.size(30.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFF2264F4),
                    contentColor = Color.Black
                ),
                onClick = {
                    if (token != null) {
                        createTask(localContext, token, CreateTaskRequest(
                            title,
                            description,
                            assignedTo.toInt(),
                            priority.toInt(),
                            deadline.toLong(),
                            departmentId.toInt(),
                            status.toInt()
                        ))
                    }
                    navController.navigate(Routes.MyTasks.route)
                }
            ) {
                Text(
                    text = "Create new Task",
                    style = TextStyle(
                        fontWeight = FontWeight(700)
                    )
                )
            }
        }
    }
}