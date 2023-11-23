package com.google.watermelonmigrasi.presentation.bottom_nav

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.watermelonmigrasi.components.TopBar
import com.google.watermelonmigrasi.core.Constants
import com.google.watermelonmigrasi.navigation.BottomNavigationItem
import com.google.watermelonmigrasi.navigation.Screens
import com.google.watermelonmigrasi.presentation.bottom_nav.home.HomeScreen
import com.google.watermelonmigrasi.presentation.bottom_nav.progress.ProgressScreen
import com.google.watermelonmigrasi.presentation.bottom_nav.support.SupportScreen
import com.google.watermelonmigrasi.presentation.bottom_nav.treatment.TreatmentScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar2(
    viewModel: ButtomNavViewModel = hiltViewModel()
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBar(
                title = currentDestination?.route ?: Constants.HOME_SCREEN,
                signOut = {
                    viewModel.signOut()
                },
                revokeAccess = {
                    viewModel.revokeAccess()
                }
            )
        },

        bottomBar = {
            NavigationBar {
                BottomNavigationItem().bottomNavigationItems().forEachIndexed { _, navigationItem ->
                    NavigationBarItem(
                        selected = navigationItem.route == currentDestination?.route,
                        label = {
                            Text(navigationItem.label)
                        },
                        icon = {
                            Icon(
                                navigationItem.icon,
                                contentDescription = navigationItem.label
                            )
                        },
                        onClick = {
                            navController.navigate(navigationItem.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) {paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screens.Home.route,
            modifier = Modifier.padding(paddingValues = paddingValues)) {
            composable(Screens.Home.route) {
              HomeScreen(
                  navController
              )
            }
            composable(Screens.Progress.route) {
               ProgressScreen(
                   navController
               )
            }
            composable(Screens.Support.route) {
                SupportScreen(
                    navController
                )
            }
            composable(Screens.Treatment.route) {
                TreatmentScreen(
                    navController
                )
            }
        }
    }
}