package com.google.watermelonmigrasi.alarms

data class ContactState(
    val contacts: List<Contact> = emptyList(),
    val isAddingContact: Boolean = false,
    val sortType: SortType = SortType.FIRST_NAME,
    val dosis: String = "",
    val obat: String = "",
    val hour: Int = 0,
    val minute: Int = 0,
    val jenis: String = "",

    ) {

}
