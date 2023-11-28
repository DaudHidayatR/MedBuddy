package com.google.watermelonmigrasi.presentation.bottom_nav.treatment.medication

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import com.google.watermelonmigrasi.components.BackIcon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MedicationTopBar(
    navigateBack: () -> Unit
) {
    TopAppBar (
        title = {
            Text(
                text = "Medication"
            )
        },
        navigationIcon = {
            BackIcon(
                navigateBack = navigateBack
            )
        }
    )
}