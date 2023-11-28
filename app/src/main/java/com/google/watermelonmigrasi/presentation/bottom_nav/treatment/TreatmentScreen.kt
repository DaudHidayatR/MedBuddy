package com.google.watermelonmigrasi.presentation.bottom_nav.treatment

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.watermelonmigrasi.R
import com.google.watermelonmigrasi.ui.theme.WatermelonMigrasiTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TreatmentScreen(
    navigateToMedication: () -> Unit = {},
    navigateToMeasurement: () -> Unit = {}
) {
    var openBottomSheet by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )
    WatermelonMigrasiTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .padding(horizontal = 15.dp, vertical = 10.dp)
                        .clip(MaterialTheme.shapes.large)
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_treatment),
                        contentDescription = "search_screen_bg",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Text(
                    "Search Screen",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(vertical = 20.dp)
                )

            }
            Box(
                contentAlignment =Alignment.BottomEnd
            ) {
                ExtendedFloatingActionButton(
                    onClick =
                    {
                        openBottomSheet = true
                    },
                    icon = { Icon(Icons.Filled.Add, "Add") },
                    text = { Text(text = "Add") },
                    modifier = Modifier
                        .padding(25.dp),
                    shape = RoundedCornerShape(50)
                )
                if (openBottomSheet) {
                    ModalBottomSheet(
                        sheetState = bottomSheetState,
                        onDismissRequest = { openBottomSheet = false },
                        dragHandle = {
                            Column(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                BottomSheetDefaults.DragHandle()
                                Text(text = "Add Treatment", style = MaterialTheme.typography.titleMedium)
                                Spacer(modifier = Modifier.height(10.dp))
                                Divider()
                            }
                        }
                    ) {
                        BottomSheetContent(
                            onHideButtonClick = {
                                scope.launch { bottomSheetState.hide() }.invokeOnCompletion {
                                    if (!bottomSheetState.isVisible) openBottomSheet = false
                                }
                            },
                            navigateToMedication = {
                                navigateToMedication()
                            },
                            navigateToMeasurement = {
                                navigateToMeasurement()
                            }
                        )
                    }
                }
            }
        }

    }
}

@Composable
fun BottomSheetContent(
    onHideButtonClick: () -> Unit,
    navigateToMedication: () -> Unit = {},
    navigateToMeasurement: () -> Unit = {}
) {
    LazyColumn(
        contentPadding = PaddingValues(16.dp)
    ) {
        item {
            ListItem(
                headlineContent = { Text(text = "Medication") },
                leadingContent = {
                    Icon(imageVector = Icons.Default.Favorite, contentDescription = null)
                },
                modifier = Modifier.clickable(onClick = navigateToMedication)
            )
            ListItem(
                headlineContent = { Text(text = "Measurement") },
                leadingContent = {
                    Icon(imageVector = Icons.Default.Favorite, contentDescription = null)
                },
                modifier = Modifier.clickable(onClick = navigateToMeasurement)

            )
        }
        item {
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = onHideButtonClick
            ) {
                Text(text = "Cancel")
            }
        }
    }
}
@Preview
@Composable
fun PreviewTreatmentScreen() {
    TreatmentScreen()
}