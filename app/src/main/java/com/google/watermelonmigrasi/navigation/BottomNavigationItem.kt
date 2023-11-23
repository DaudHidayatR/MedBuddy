package com.google.watermelonmigrasi.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddChart
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val label : String = "",
    val icon : ImageVector = Icons.Filled.Home,
    val route : String = ""
) {
    fun bottomNavigationItems() : List<BottomNavigationItem> {
        return listOf(
            BottomNavigationItem(
                label = "Home",
                icon = Icons.Filled.Home,
                route = Screens.Home.route
            ),
            BottomNavigationItem(
                label = "Progress",
                icon = Icons.Filled.AddChart,
                route = Screens.Progress.route
            ),
            BottomNavigationItem(
                label = "Support",
                icon = Icons.Filled.AccountCircle,
                route = Screens.Support.route
            ),
            BottomNavigationItem(
                label = "Treatment",
                icon = Icons.Filled.AccountCircle,
                route = Screens.Treatment.route
            ),
        )
    }
}