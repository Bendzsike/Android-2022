package com.example.tracker.ui.navigationBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.EventAvailable
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.tracker.navigation.Routes

sealed class NavigationItem(var route: String, var icon: ImageVector, var title: String) {
    object MyTasks : NavigationItem(Routes.MyTasks.route, Icons.Filled.EventAvailable, "My Tasks")
    object Profile : NavigationItem(Routes.Profile.route, Icons.Filled.Person, "Profile")
}
