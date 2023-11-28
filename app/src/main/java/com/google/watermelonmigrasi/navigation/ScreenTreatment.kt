package com.google.watermelonmigrasi.navigation

sealed class ScreenTreatment(val route : String) {

    object Treatment : ScreenTreatment("Treatment")

    object Measurement : ScreenTreatment("Measurement")

    object Medication : ScreenTreatment("Medication")

}