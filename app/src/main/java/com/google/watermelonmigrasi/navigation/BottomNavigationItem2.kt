package com.google.watermelonmigrasi.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddChart
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationItem2(
    val label : String = "",
    val icon : ImageVector = Icons.Filled.Home,
    val route : String = ""
){
    object Home: BottomNavigationItem2(
     label = "Home",
     icon = Icons.Filled.Home,
     route = ScreenBottom.Home.route
    )
    object Progress: BottomNavigationItem2(
        label = "Progress",
        icon = Icons.Filled.AddChart,
        route = ScreenBottom.Progress.route
    )
    object Support: BottomNavigationItem2(
        label = "Support",
        icon = Icons.Filled.AccountCircle,
        route = ScreenBottom.Support.route
    )
    object Treatment: BottomNavigationItem2(
        label = "Treatment",
        icon = Icons.Filled.AccountCircle,
        route = ScreenBottom.Treatment.route

    )


}