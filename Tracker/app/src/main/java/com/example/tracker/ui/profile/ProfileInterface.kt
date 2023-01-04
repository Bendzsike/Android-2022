package com.example.tracker.ui.profile

import android.content.SharedPreferences
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.tracker.ui.navigationBar.BottomNavigationBar
import com.example.tracker.ui.navigationBar.TopBar
import com.example.tracker.ui.users.*

@Composable
fun Profile(navController: NavController, sharedPreferences: SharedPreferences) {
    val userId = sharedPreferences.getInt("userId", 0)

    Scaffold(
        backgroundColor = Color.White,
        topBar = { TopBar(title = "Profile", sharedPreferences = sharedPreferences) },
        bottomBar = { BottomNavigationBar(navController) }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    if (!getImage(userId).isNullOrEmpty()) {
                        getImage(userId)
                    } else {
                        "https://arc-anglerfish-arc2-prod-tronc.s3.amazonaws.com/public/5SCEDPSJONEADD2KEXXC4OHPC4.jpg"
                    }
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Black, CircleShape)
                    .padding(4.dp)
            )

            Spacer(Modifier.size(20.dp))

            getName(userId)?.let { it1 ->
                Text(
                    text = it1,
                    style = TextStyle(
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                )
            }

            Spacer(Modifier.size(20.dp))

            val type = getType(userId)

            Text(
                text = if (type == 0) {
                    "Mentor"
                } else {
                    "Software Developer"
                },
                style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.DarkGray
                )
            )

            Spacer(Modifier.size(30.dp))

            if(type != 0) {
                val mentorId = getUserByDepartmentAndType(getDepartmentId(userId), 0)
                Image(
                    painter = rememberAsyncImagePainter(
                        if (!getImage(mentorId).isNullOrEmpty()) {
                            getImage(mentorId)
                        } else {
                            "https://arc-anglerfish-arc2-prod-tronc.s3.amazonaws.com/public/5SCEDPSJONEADD2KEXXC4OHPC4.jpg"
                        }
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.Black, CircleShape)
                        .padding(4.dp)
                )

                Spacer(Modifier.size(20.dp))

                getName(mentorId)?.let { it1 ->
                    Text(
                        text = it1,
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    )
                }

                Spacer(Modifier.size(20.dp))

                Text(
                    text = getName(userId) + "'s mentor",
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color.DarkGray
                    )
                )

                Spacer(Modifier.size(30.dp))
            }

            Divider(
                color = Color.LightGray.copy(0.5f),
                thickness = 1.dp,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.size(10.dp))

            getEmail(userId)?.let { it1 ->
                Text(
                    text = it1,
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color.DarkGray
                    )
                )
            }

            Spacer(Modifier.size(10.dp))

            Divider(
                color = Color.LightGray.copy(0.5f),
                thickness = 1.dp,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.size(10.dp))

            getPhoneNumber(userId)?.let { it1 ->
                Text(
                    text = it1,
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color.DarkGray
                    )
                )
            }

            Spacer(Modifier.size(10.dp))

            Divider(
                color = Color.LightGray.copy(0.5f),
                thickness = 1.dp,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(Modifier.size(10.dp))

            getLocation(userId)?.let { it1 ->
                Text(
                    text = "Office Location: $it1",
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color.DarkGray
                    )
                )
            }
        }
    }
}