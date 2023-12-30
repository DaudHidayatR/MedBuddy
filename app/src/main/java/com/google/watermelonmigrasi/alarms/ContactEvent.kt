package com.google.watermelonmigrasi.alarms

sealed interface ContactEvent {
    object SaveContact : ContactEvent
    data class SetFirstName(val firstName: String) : ContactEvent
    data class SetLastName(val lastName: String) : ContactEvent
    data class SetPhoneNumber(val phoneNumber: String) : ContactEvent
    data class EditContact(val dosis: Contact) : ContactEvent
    object ShowDialog : ContactEvent
    object HideDialog : ContactEvent
    data class cancelAlarm(val cancel: String) : ContactEvent
    data class SortContacts(val sortType: SortType) : ContactEvent
    data class DeleteContact(val contact: Contact) : ContactEvent
    data class SetDosis(val dosis: String) : ContactEvent
    data class SetObat(val obat: String) : ContactEvent
    data class SetHour(val hour: Int) : ContactEvent
    data class SetMinute(val minute: Int) : ContactEvent
    data class SetJenis(val jenis: String) : ContactEvent
}