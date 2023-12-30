package com.google.watermelonmigrasi.alarms

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contact(
    val dosis: String,
    val obat: String,
    val hour: Int,
    val minute: Int,
    val jenis: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
) {
    constructor() : this(
        "",
        "",
        0,
        0,
        "",
        0
    )
}
