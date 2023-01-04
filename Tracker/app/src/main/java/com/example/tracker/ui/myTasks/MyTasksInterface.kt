package com.example.tracker.ui.myTasks

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.icu.text.SimpleDateFormat
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tracker.navigation.Routes
import com.example.tracker.ui.groups.getGroupById
import com.example.tracker.ui.groups.groupUistate
import com.example.tracker.ui.navigationBar.BottomNavigationBar
import com.example.tracker.ui.navigationBar.TopBarWithButton
import com.example.tracker.ui.users.getName
import com.example.tracker.ui.users.userUistate

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun MyTasks(navController: NavController, sharedPreferences: SharedPreferences) {
    val lifecycleOwner = rememberUpdatedState(LocalLifecycleOwner.current)

    Scaffold(
        backgroundColor = Color.White,
        topBar = { TopBarWithButton(title = "My Tasks", sharedPreferences, navController) },
        bottomBar = { BottomNavigationBar(navController) }
    ) {
        LazyColumn {
            uistate.observe(lifecycleOwner.value) {
                items(it.tasks) { task ->
                    TaskCard(task = task, navController = navController)
                }
            }
        }
    }
}

@SuppressLint("SimpleDateFormat")
@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun TaskCard(task: Task, navController: NavController) {
    val lifecycleOwner = rememberUpdatedState(LocalLifecycleOwner.current)
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable{
                navController.navigate("${Routes.DetailedTask.route}/${task.taskId}")
            },
        elevation = 4.dp,
        backgroundColor = Color(0xFFE3EAF8)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                var groupName: String? = ""
                groupUistate.observe(lifecycleOwner.value) {
                    groupName = getGroupById(task.groupId)
                }
                groupName?.let {
                    Text(
                        text = it,
                        style = TextStyle(
                            fontSize = 12.sp,
                            color = Color.DarkGray
                        )
                    )
                }

                Text(
                    text = task.title,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                )

                var creatorName: String? = ""
                var assignee: String? = ""
                userUistate.observe(lifecycleOwner.value) {
                    creatorName = getName(task.createdBy)
                    assignee = getName(task.assignee)
                }

                Row {
                    creatorName?.let {
                        Text(
                            text = "$it ",
                            style = TextStyle(
                                fontSize = 14.sp,
                                color = Color.DarkGray
                            )
                        )
                    }
                    val sdf = SimpleDateFormat("h:mm a")
                    Text(
                        text = sdf.format(task.createdAt),
                        style = TextStyle(
                            fontSize = 14.sp,
                            color = Color.DarkGray
                        )
                    )
                }

                Row {
                    Text(
                        text = "Assignee: ",
                        style = TextStyle(
                            fontSize = 14.sp,
                            color = Color.DarkGray
                        )
                    )

                    assignee?.let {
                        Text(
                            text = it,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.DarkGray
                            )
                        )
                    }
                }

                Divider(
                    color = Color.LightGray.copy(0.5f),
                    thickness = 1.dp,
                    modifier = Modifier.fillMaxWidth()
                )

                Row {
                    Text(
                        text = "Deadline: ",
                        style = TextStyle(
                            fontSize = 14.sp,
                            color = Color.DarkGray
                        )
                    )

                    val sdf = SimpleDateFormat("MMMM dd yyyy")

                    Text(
                        text = sdf.format(task.deadline),
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.DarkGray
                        )
                    )
                }

                Text(
                    text = task.description,
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = Color.DarkGray
                    )
                )

                Text(
                    text = task.progress.toString() + "% done",
                    style = TextStyle(
                        fontSize = 12.sp,
                        color = Color.DarkGray
                    ),
                    modifier = Modifier
                        .align(Alignment.End)
                )

                LinearProgressIndicator(
                    progress = task.progress.toFloat(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.End),
                    color = Color(0xFF2264F4)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(end = 10.dp)
                    .padding(top = 45.dp),
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = when (task.status) {
                        TaskStatus.NEW -> "New"
                        TaskStatus.IN_PROGRESS -> "In progress"
                        TaskStatus.DONE -> "Done"
                        TaskStatus.BLOCKED -> "Blocked"
                    },
                    style = TextStyle(
                        fontWeight = FontWeight(700),
                        fontSize = 16.sp
                    ),
                    modifier = Modifier
                        .background(Color(0xFF2264F4))
                        .padding(4.dp)

                )
                Spacer(Modifier.size(20.dp))
                Row {
                    Text(
                        text = when (task.priority) {
                            TaskPriority.LOW -> "Low prio "
                            TaskPriority.MEDIUM -> "Medium prio "
                            TaskPriority.HIGH -> "High prio "
                        },
                        style = TextStyle(
                            fontSize = 12.sp,
                            color = Color.DarkGray
                        )
                    )

                    Box(
                        modifier = Modifier
                            .padding(top = 2.dp)
                            .size(12.dp)
                            .clip(CircleShape)
                            .background(
                                when (task.priority) {
                                    TaskPriority.LOW -> Color.Green
                                    TaskPriority.MEDIUM -> Color.Yellow
                                    TaskPriority.HIGH -> Color.Red
                                }
                            )
                    )
                }
            }

        }
    }
}