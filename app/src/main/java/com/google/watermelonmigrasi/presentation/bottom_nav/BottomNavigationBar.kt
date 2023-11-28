package com.google.watermelonmigrasi.presentation.bottom_nav

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.watermelonmigrasi.components.TopBar
import com.google.watermelonmigrasi.core.Constants
import com.google.watermelonmigrasi.navigation.BottomNavigationItem
import com.google.watermelonmigrasi.navigation.BottomNavigationItem2
import com.google.watermelonmigrasi.navigation.HomeNavGraph

//@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar2(
    viewModel: ButtomNavViewModel = hiltViewModel(),
    navController: NavHostController = rememberNavController()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val screens = listOf(
        BottomNavigationItem2.Home,
        BottomNavigationItem2.Progress,
        BottomNavigationItem2.Support,
        BottomNavigationItem2.Treatment,
    )
    val bottomBarDestination = screens.any { it.route == currentDestination?.route }


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            if (bottomBarDestination) {
                TopBar(
                    title = currentDestination?.route ?: Constants.HOME_SCREEN,
                    signOut = {
                        viewModel.signOut()
                    },
                    revokeAccess = {
                        viewModel.revokeAccess()
                    }
                )
            }
        },

        bottomBar = {

            if (bottomBarDestination) {
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
        }
    ) { paddingValues ->
        HomeNavGraph(navController = navController, padding = Modifier.padding(paddingValues))
    }
}
@Preview
@Composable
fun PreviewBottomNavigationBar() {
    BottomNavigationBar2()
}