package com.google.watermelonmigrasi.navigation

sealed class Screens(val route : String) {
    object Home : Screens("Home")
    object Progress : Screens("Progress")
    object Support : Screens("Support")
    object Treatment : Screens("Treatment")
}