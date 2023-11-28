package com.google.watermelonmigrasi.navigation

sealed class ScreenBottom(val route : String) {
    object Home : ScreenBottom("Home")
    object Progress : ScreenBottom("Progress")
    object Support : ScreenBottom("Support")
    object Treatment : ScreenBottom("Treatment")



}