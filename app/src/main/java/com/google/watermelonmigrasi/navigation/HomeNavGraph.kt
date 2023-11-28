package com.google.watermelonmigrasi.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.google.watermelonmigrasi.presentation.bottom_nav.home.HomeScreen
import com.google.watermelonmigrasi.presentation.bottom_nav.progress.ProgressScreen
import com.google.watermelonmigrasi.presentation.bottom_nav.support.SupportScreen
import com.google.watermelonmigrasi.presentation.bottom_nav.treatment.TreatmentScreen
import com.google.watermelonmigrasi.presentation.bottom_nav.treatment.measurement.MeasurementScreen
import com.google.watermelonmigrasi.presentation.bottom_nav.treatment.medication.MedicationScreen

@Composable
fun HomeNavGraph(navController: NavHostController, padding: Modifier) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomNavigationItem2.Home.route,
        modifier = padding
    ) {
        composable(route = BottomNavigationItem2.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(route = BottomNavigationItem2.Progress.route) {
            ProgressScreen(navController = navController)
        }
        composable(route = BottomNavigationItem2.Support.route) {
            SupportScreen(navController = navController)
        }
        composable(route = BottomNavigationItem2.Treatment.route) {
            TreatmentScreen(
                navigateToMeasurement = {
                    Graph.MEDICATION
            }, navigateToMedication = {
                    navController.navigate(Graph.MEDICATION)
            }
            )
        }
        MeasurementNav(navController = navController)
        MedicationNav(navController = navController)
    }
}

fun NavGraphBuilder.MedicationNav(
    navController: NavHostController
) {
    navigation(
        startDestination = ScreenTreatment.Medication.route,
        route = Graph.MEDICATION,
    ) {
        composable(route = ScreenTreatment.Medication.route) {
            MedicationScreen( navigateBack = {
                navController.popBackStack()
            })
        }
    }
}

fun NavGraphBuilder.MeasurementNav(
    navController: NavHostController
) {
    navigation(
        startDestination = ScreenTreatment.Measurement.route,
        route = Graph.MEDICATION,
    ) {
        composable(route = ScreenTreatment.Measurement.route) {
            MeasurementScreen(navController = navController)
        }
    }
}
