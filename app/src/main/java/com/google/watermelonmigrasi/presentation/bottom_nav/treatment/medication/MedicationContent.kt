package com.google.watermelonmigrasi.presentation.bottom_nav.treatment.medication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TimeInput
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.watermelonmigrasi.components.DosisField
import com.google.watermelonmigrasi.components.NameField
import com.google.watermelonmigrasi.core.Constants
import com.google.watermelonmigrasi.ui.theme.WatermelonMigrasiTheme
import java.time.LocalDateTime

@Composable
@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
fun MedicationContent1(
//    padding: PaddingValues,
    setDrug: (name: String, unit: String) -> Unit,
) {
    var name by rememberSaveable(
        stateSaver = TextFieldValue.Saver,
        init = {
            mutableStateOf(
                value = TextFieldValue(
                    text = Constants.EMPTY_STRING
                )
            )
        }
    )

    val options = listOf("IU", "ampoule(s)", "capsule(s)", "inhaler(s)", "mg(s)", "ml(s)", "patch(s)", "puff(s)", "spray(s)", "tablet(s)", "unit(s)",  "pill(s)")
    val keyboard = LocalSoftwareKeyboardController.current
    var unit by remember { mutableStateOf(options[0]) }
    var expanded by rememberSaveable { mutableStateOf(false) }
    Column(
        modifier = Modifier.padding(start = 30.dp, end = 35.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Column(
            modifier = Modifier.padding(top = 100.dp, bottom = 20.dp)
        ) {
            Text(
                text = "Which Medication would you like to set the reminder for",
                style = MaterialTheme.typography.titleMedium
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        NameField(
            name = name,
            onNameValueChange = { newValue ->
                name = newValue
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded },
        ) {
            TextField(
                modifier = Modifier.menuAnchor(),
                readOnly = true,
                value = unit,
                onValueChange = {},
                label = { Text("Unit") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
            ) {
                options.forEach { selectionOption ->
                    DropdownMenuItem(
                        text = { Text(selectionOption) },
                        onClick = {
                            unit = selectionOption
                            expanded = false
                        },
                    )
                }
            }

        }
        Spacer(modifier = Modifier.height(25.dp))
        Box(modifier = Modifier.padding(25.dp, 0.dp, 25.dp, 0.dp)) {
            Button(
                onClick = {
                    keyboard?.hide()
                    setDrug(name.text, unit)
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White),

                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(
                    text = "Next",
                    fontSize = 15.sp
                )
            }

        }
    }
}
@Preview
@Composable
fun MedicationContentPreview() {
    WatermelonMigrasiTheme {
        MedicationContent1( setDrug = { Name, Unit -> })
    }
}

@Composable
@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
fun MedicationContent2(
//    padding: PaddingValues,
    setDay: ( day: String) -> Unit,
) {

    val options = listOf("Once daily", "Twice daily", "On demand" )
    val keyboard = LocalSoftwareKeyboardController.current
    var day by remember { mutableStateOf(options[0]) }
    var expanded by rememberSaveable { mutableStateOf(false) }
    Column(
        modifier = Modifier.padding(start = 30.dp, end = 35.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Column(
            modifier = Modifier.padding(top = 100.dp, bottom = 20.dp)
        ) {
            Text(
                text = "How often do you take this medication?",
                style = MaterialTheme.typography.titleMedium
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded },
        ) {
            TextField(
                modifier = Modifier.menuAnchor(),
                readOnly = true,
                value = day,
                onValueChange = {},
                label = { Text("") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
            ) {
                options.forEach { selectionOption ->
                    DropdownMenuItem(
                        text = { Text(selectionOption) },
                        onClick = {
                            day = selectionOption
                            expanded = false
                        },
                    )
                }
            }

        }
        Spacer(modifier = Modifier.height(30.dp))
        Box(modifier = Modifier.wrapContentHeight(Alignment.Bottom).padding(25.dp, 0.dp, 25.dp, 0.dp)) {
            Button(
                onClick = {
                    keyboard?.hide()
                    setDay(day)
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White),

                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(
                    text = "Next",
                    fontSize = 15.sp
                )
            }

        }
    }
}

@Preview
@Composable
fun MedicationContent2Preview() {
    WatermelonMigrasiTheme {
        MedicationContent2( setDay = {  day -> })
    }
}


@Composable
@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
fun MedicationContent3(
//    padding: PaddingValues,
    setTime: (time: Int, dosis: Int) -> Unit,
) {
    var dosis by rememberSaveable(
        stateSaver = TextFieldValue.Saver,
        init = {
            mutableStateOf(
                value = TextFieldValue(
                    text = Constants.EMPTY_STRING
                )
            )
        }
    )
    val dateTime = LocalDateTime.now()
    var selectedHour by remember {
        mutableStateOf(0) // or use  mutableStateOf(0)
    }

    var selectedMinute by remember {
        mutableStateOf(0) // or use  mutableStateOf(0
    }

    var expanded by rememberSaveable { mutableStateOf(false) }


    val timePickerState = rememberTimePickerState(
        initialHour = selectedHour,
        initialMinute = selectedMinute,
        is24Hour = false

    )
    Column(
        modifier = Modifier.padding(start = 45.dp, end = 35.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Column(
            modifier = Modifier.padding(top = 100.dp, bottom = 20.dp)
        ) {
            Text(
                text = "How often do you take this medication?",
                style = MaterialTheme.typography.titleMedium
            )
        }
        val formattedTime = String.format("%02d:%02d", selectedHour, selectedMinute)

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded },
        ) {
            TextField(
                readOnly = true,
                value = "$formattedTime",
                onValueChange = {},
                modifier = Modifier.menuAnchor(),
                label = { Text("Time") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
            ) {
                    AlertDialog(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = MaterialTheme.colorScheme.surface,
                                shape = RoundedCornerShape(size = 12.dp)
                            ),
                        onDismissRequest = { expanded = false }
                    ) {
                        Column(
                            modifier = Modifier
                                .background(
                                    color = Color.LightGray.copy(alpha = 0.3f)
                                ),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            TimeInput(state = timePickerState, )


                            Row(
                                modifier = Modifier
                                    .padding(top = 12.dp)
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.End
                            ) {
                                // dismiss button
                                TextButton(onClick = { expanded = false }) {
                                    Text(text = "Dismiss")
                                }

                                // confirm button
                                TextButton(
                                    onClick = {
                                        expanded = false
                                        selectedHour = timePickerState.hour
                                        selectedMinute = timePickerState.minute
                                    }
                                ) {
                                    Text(text = "Confirm")
                                }
                            }
                        }
                    }
                }
            }
        Spacer(modifier = Modifier.height(25.dp))
        DosisField(
            dosis = dosis,
            onNameValueChange = { newValue ->
                dosis = newValue
            }
        )
    }

}

@Preview
@Composable
fun MedicationContent3Preview() {
    WatermelonMigrasiTheme {
        MedicationContent3( setTime = { time, dosis -> })
    }
}



@Composable
@OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)
fun MedicationContent4(
//    padding: PaddingValues,
    setTime: (time: Int, dosis: Int) -> Unit,
) {
    var dosis by rememberSaveable(
        stateSaver = TextFieldValue.Saver,
        init = {
            mutableStateOf(
                value = TextFieldValue(
                    text = Constants.EMPTY_STRING
                )
            )
        }
    )
    Column(
        modifier = Modifier.padding(start = 45.dp, end = 35.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Column(
            modifier = Modifier.padding(top = 100.dp, bottom = 20.dp)
        ) {
            Text(
                text = "How often do you take this medication?",
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}
