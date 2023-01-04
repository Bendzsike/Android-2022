package com.example.tracker.ui.navigationBar

import android.content.SharedPreferences
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddTask
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.tracker.navigation.Routes
import com.example.tracker.ui.users.getImage

@Composable
fun TopBar(title: String, sharedPreferences: SharedPreferences) {
    val userId = sharedPreferences.getInt("userId", 0)
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        if(!getImage(userId).isNullOrEmpty()) {
                            getImage(userId)
                        } else {
                            "https://arc-anglerfish-arc2-prod-tronc.s3.amazonaws.com/public/5SCEDPSJONEADD2KEXXC4OHPC4.jpg"
                        }
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.Black, CircleShape)
                        .padding(4.dp)
                )
                Spacer(Modifier.size(10.dp))
                Text(
                    text = title,
                    style = TextStyle(
                        fontWeight = FontWeight(700),
                        fontSize = 24.sp
                    )
                )
            }
                },
        backgroundColor = Color.White,
        contentColor = Color.Black
    )
}

@Composable
fun TopBarWithButton(title: String, sharedPreferences: SharedPreferences, navController: NavController) {
    val userId = sharedPreferences.getInt("userId", 0)
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        if(!getImage(userId).isNullOrEmpty()) {
                            getImage(userId)
                        } else {
                            "https://arc-anglerfish-arc2-prod-tronc.s3.amazonaws.com/public/5SCEDPSJONEADD2KEXXC4OHPC4.jpg"
                        }
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                        .border(2.dp, Color.Black, CircleShape)
                        .padding(4.dp)
                )
                Spacer(Modifier.size(10.dp))
                Text(
                    text = title,
                    style = TextStyle(
                        fontWeight = FontWeight(700),
                        fontSize = 24.sp
                    )
                )

                Spacer(Modifier.size(160.dp))

                Icon(
                    Icons.Outlined.AddTask,
                    "add",
                    Modifier
                        .fillMaxWidth()
                        .size(40.dp)
                        .clickable {
                            navController.navigate(Routes.CreateTask.route)
                        }
                )
            }
        },
        backgroundColor = Color.White,
        contentColor = Color.Black
    )
}