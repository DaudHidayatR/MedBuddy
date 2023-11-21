package com.google.watermelonmigrasi.navigation

import com.google.watermelonmigrasi.R

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String) {
    object Home: BottomNavItem("Home", R.drawable.ic_home, "home")
    object Progress: BottomNavItem("Progress", R.drawable.ic_progress, "progress")
//    object Support: BottomNavItem("Support", R.drawable.ic_support, "support")
    object Treatment: BottomNavItem("Treatment", R.drawable.ic_treatment, "treatment")
}