package com.google.watermelonmigrasi.alarms

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun MyCard(
    data: ContactState,
) {
    val contact = data.contacts.last()
    Card(
        modifier = androidx.compose.ui.Modifier
            .fillMaxWidth()
    ) {

        Text(text = contact.dosis, fontSize = 12.sp)
        Text(text = contact.obat, fontSize = 12.sp)
        Text(text = contact.jenis, fontSize = 12.sp)
        Text(text = contact.hour.toString(), fontSize = 12.sp)
        Text(text = contact.minute.toString(), fontSize = 12.sp)

    }
}

@Preview
@Composable
fun CardPreview() {
    MyCard(
        data = ContactState(
            contacts = listOf(
                Contact(
                    dosis = "dosis",
                    obat = "obat",
                    hour = 13,
                    minute = 0,
                    jenis = "jenis"
                )
            )
        )
    )
}