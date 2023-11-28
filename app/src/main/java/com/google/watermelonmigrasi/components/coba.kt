package com.google.watermelonmigrasi.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.RadioButtonUnchecked
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.google.watermelonmigrasi.ui.theme.WatermelonMigrasiTheme

@Composable
fun coba(){
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.TopStart)
    ) {
        Button(onClick = { expanded = true }) {
            Text("Click to show menu")
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                text = { Text("Edit") },
                onClick = { /* Handle edit! */ },
                leadingIcon = {
                    Icon(
                        Icons.Outlined.Edit,
                        contentDescription = null
                    )
                })
            DropdownMenuItem(
                text = { Text("Settings") },
                onClick = { /* Handle settings! */ },
                leadingIcon = {
                    Icon(
                        Icons.Outlined.Settings,
                        contentDescription = null
                    )
                })
        }
    }
}
@Preview
@Composable
fun PreviewCoba(){
    WatermelonMigrasiTheme {
        coba()
    }

}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun DropdownInput (){
//
//    var expanded by remember { mutableStateOf(false) }
//
//    var gender by  remember { mutableStateOf("") }
//    Box(
//        modifier = Modifier
//            .fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ) {
//        ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = {expanded = it}) {
//            TextField(
//                value = gender,
//                onValueChange ={},
//                readOnly = true,
//                trailingIcon = {
//                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
//                },
//                colors = ExposedDropdownMenuDefaults.textFieldColors(),
//                modifier = Modifier.menuAnchor()
//            )
//            ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
//                DropdownMenuItem(
//                    text = { Text(text = "male")},
//                    onClick = {
//                        expanded = false
//                        gender = "male"
//                    }
//                )
//                DropdownMenuItem(
//                    text = { Text(text = "femil")},
//                    onClick = {
//                        expanded = false
//                        gender = "female"
//                    }
//                )
//            }
//        }
//    }
//}
//@Preview
//@Composable
//fun PreviewCoba2(){
//    WatermelonMigrasiTheme {
//        DropdownInput()
//    }
//
//}

@Composable
fun MyUI() {
    val radioOptions = listOf("Linux", "Mac", "Windows")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[2]) }

    var selectedItem by remember {
        mutableStateOf(radioOptions[0])
    }


    Column(modifier = Modifier.selectableGroup()) {
        radioOptions.forEach { label ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .selectable(
                        selected = (selectedItem == label),
                        onClick = { selectedItem = label },
                        role = Role.RadioButton
                    )
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.padding(end = 16.dp),
                    imageVector = if (selectedItem == label)
                        Icons.Outlined.CheckCircle else
                        Icons.Outlined.RadioButtonUnchecked,

                    contentDescription = null,
                    tint = Color.Magenta
                )
                Text(text = label)
            }
                
            }
            Column {
                Button(onClick = {  }) {
            }
        }
    }
}

@Preview
@Composable
fun PreviewMyUI(){
    WatermelonMigrasiTheme {
        MyUI()
    }

}



@Composable
fun AlertDialogM3() {

    var openDialog by remember { mutableStateOf(false) }


    IconButton(onClick = { openDialog = true }) {
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = "Delete Icon"
        )
    }

    if (openDialog) {
        AlertDialog(
            onDismissRequest = { openDialog = false },
            title = {
                Text(text = "Delete Selected Image?")
            },
            text = {
                Text(text = "Are you sure, you want to permanently delete the selected image.")
            },
            confirmButton = {
                TextButton(onClick = {
                    /* viewModel.deleteImage */
                    openDialog = false
                }) {
                    Text(text = "Yes")
                }
            },
            dismissButton = {
                TextButton(onClick = { openDialog = false }) {
                    Text(text = "No")
                }
            }
        )
    }
}

@Composable
fun DialogM3() {
    var openDialog by remember { mutableStateOf(false) }
    var gender by  remember { mutableStateOf("") }
    val radioOptions = listOf("Linux", "Mac", "Windows")
    var selectedItem by remember {
        mutableStateOf(radioOptions[0])
    }

    TextField(
        value = gender,
        onValueChange ={},
        readOnly = true,
    )

    IconButton(onClick = { openDialog = true }) {
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = "Delete Icon"
        )
    }


    if (openDialog) {
        Dialog(onDismissRequest = { openDialog = false }) {
            Surface {
                Column(modifier = Modifier.selectableGroup()) {
                    radioOptions.forEach { label ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(56.dp)
                                .selectable(
                                    selected = (selectedItem == label),
                                    onClick = { selectedItem = label },
                                    role = Role.RadioButton
                                )
                                .padding(horizontal = 16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                modifier = Modifier.padding(end = 16.dp),
                                imageVector = if (selectedItem == label)
                                    Icons.Outlined.CheckCircle else
                                    Icons.Outlined.RadioButtonUnchecked,

                                contentDescription = null,
                                tint = Color.Magenta
                            )
                            Text(text = label)
                        }

                    }
                    Column {

                        Button(onClick = { gender = selectedItem   }) {
                            Text(text = "Ok")
                        }
                    }
                }

            }
        }
    }
}

@Preview
@Composable
fun PreviewDialogM3(){
    WatermelonMigrasiTheme {
        DialogM3()
    }
}

