package com.google.watermelonmigrasi.presentation.bottom_nav.treatment.medication

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.watermelonmigrasi.ui.theme.WatermelonMigrasiTheme

@Composable
fun MedicationScreen(navigateBack: () -> Unit) {
    WatermelonMigrasiTheme {
        Scaffold(
            topBar = {
                MedicationTopBar(
                    navigateBack = navigateBack
                )
            },
            content = { padding ->
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,

                    ) {

                }
            }
        )
    }
}