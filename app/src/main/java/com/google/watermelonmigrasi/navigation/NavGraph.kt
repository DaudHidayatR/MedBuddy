package com.google.watermelonmigrasi.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.watermelonmigrasi.presentation.bottom_nav.BottomNavigationBar2
import com.google.watermelonmigrasi.presentation.forgot_password.ForgotPasswordScreen
import com.google.watermelonmigrasi.presentation.sign_in.SignInScreen
import com.google.watermelonmigrasi.presentation.sign_up.SignUpScreen
import com.google.watermelonmigrasi.presentation.verify_email.VerifyEmailScreen


@Composable
@ExperimentalComposeUiApi
fun NavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.SignInScreen.route,
        route = Graph.AUTHENTICATION,
    ) {
        composable(
            route = Screen.SignInScreen.route
        ) {
            SignInScreen(
                navigateToForgotPasswordScreen = {
                    navController.navigate(Screen.ForgotPasswordScreen.route)
                },
                navigateToSignUpScreen = {
                    navController.navigate(Screen.SignUpScreen.route)
                }
            )
        }
        composable(
            route = Screen.ForgotPasswordScreen.route
        ) {
            ForgotPasswordScreen(
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
        composable(
            route = Screen.SignUpScreen.route
        ) {
            SignUpScreen(
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
        composable(
            route = Screen.VerifyEmailScreen.route
        ) {
            VerifyEmailScreen(
                navigateToProfileScreen = {
                    navController.navigate(Graph.HOME) {
                        popUpTo(navController.graph.id) {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable(
            route = Graph.HOME
        ) {
            BottomNavigationBar2()
        }
    }
}

object Graph {
    const val AUTHENTICATION = "auth_graph"
    const val HOME = "home_graph"
    const val MEDICATION = "medication_graph"
}
