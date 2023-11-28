package com.google.watermelonmigrasi.presentation.bottom_nav.treatment.medication

import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.watermelonmigrasi.ui.theme.WatermelonMigrasiTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownInputpage1 (){
    val options = listOf("","IU", "ampoule(s)", "capsule(s)", "inhaler(s)", "mg(s)", "ml(s)", "patch(s)", "puff(s)", "spray(s)", "tablet(s)", "unit(s)",  "pill(s)")
    var expanded by rememberSaveable { mutableStateOf(false) }
    var unit by rememberSaveable { mutableStateOf(options[0]) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
    ) {
        TextField(
            modifier = Modifier.menuAnchor(),
            readOnly = true,
            value = unit,
            onValueChange = {},
            label = { Text("Label") },
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
}
@Preview
@Composable
fun PreviewDropdownInputpage1(){
    WatermelonMigrasiTheme {
        DropdownInputpage1()
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownInputpage2 (){
    val options = listOf("","Once daily", "Twice daily", "On demand" )
    var expanded by rememberSaveable { mutableStateOf(false) }
    var often by rememberSaveable { mutableStateOf(options[0]) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
    ) {
        TextField(
            modifier = Modifier.menuAnchor(),
            readOnly = true,
            value = often,
            onValueChange = {},
            label = { Text("Label") },
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
                        often = selectionOption
                        expanded = false
                    },
                )
            }
        }
    }
}
@Preview
@Composable
fun PreviewDropdownInputpage2(){
    WatermelonMigrasiTheme {
        DropdownInputpage2()
    }
}
