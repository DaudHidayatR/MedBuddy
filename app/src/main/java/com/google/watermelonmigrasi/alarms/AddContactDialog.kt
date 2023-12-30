package com.google.watermelonmigrasi.alarms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TimeInput
import androidx.compose.material3.TimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.watermelonmigrasi.alarms.alarm.Alarm
import com.google.watermelonmigrasi.alarms.alarm.AlarmItem
import java.time.LocalDateTime


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddContactDialog(
    state: ContactState,
    onEvent: (ContactEvent) -> Unit,
    modifier: Modifier = Modifier,
    scheduler: Alarm

) {
    
    var alarmItem: AlarmItem? = null
    var obat by remember {
        mutableStateOf("")
    }
    var hour by remember {
        mutableStateOf(0)
    }
    var minute by remember {
        mutableStateOf(0)
    }

    AlertDialog(
        modifier = modifier,
        onDismissRequest = {
            onEvent(ContactEvent.HideDialog)
        },
        title = { Text(text = "Add contact") },
        text = {
            val dateTime = LocalDateTime.now()

            val coba = remember {
                TimePickerState(
                    initialHour = dateTime.hour,
                    initialMinute = dateTime.minute,
                    is24Hour = true
                )
            }


            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                TextField(
                    value = state.dosis,
                    onValueChange = {
                        onEvent(ContactEvent.SetDosis(it))

                    },
                    placeholder = {
                        Text(text = "Dosis")
                    }
                )
                TextField(
                    value = state.obat,
                    onValueChange = {
                        onEvent(ContactEvent.SetObat(it))
                        obat = it
                    },
                    placeholder = {
                        Text(text = "Obat")
                    }
                )
                TextField(
                    value = state.jenis,
                    onValueChange = {
                        onEvent(ContactEvent.SetJenis(it))
                    },
                    placeholder = {
                        Text(text = "Jenis")
                    }
                )
                TimeInput(
                    state = coba,
                    modifier = Modifier.padding(16.dp)
                )
                onEvent(ContactEvent.SetHour(coba.hour))
                onEvent(ContactEvent.SetMinute(coba.minute))
                hour = coba.hour
                minute = coba.minute

            }
        },
        buttons = {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                Button(onClick = {
                    onEvent(ContactEvent.SaveContact)
                    alarmItem = AlarmItem(
                        obat = obat,
                        hour = hour,
                        minute = minute
                    )
                    alarmItem?.let(scheduler::schedule)
                    obat = ""
                    hour = 0
                    minute = 0

                }) {
                    Text(text = "Save")
                }
            }
        }
    )
}