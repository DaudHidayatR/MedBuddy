package com.google.watermelonmigrasi.alarms

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
class ContactViewModel(
    private val dao: ContactDao
) : ViewModel() {

    private val _sortType = MutableStateFlow(SortType.FIRST_NAME)
    private val _contacts = _sortType
        .flatMapLatest { sortType ->
            when (sortType) {
                SortType.FIRST_NAME -> dao.getContactsOrderedByFirstName()
                SortType.LAST_NAME -> dao.getContactsOrderedByLastName()
                SortType.PHONE_NUMBER -> dao.getContactsOrderedByPhoneNumber()
            }
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    private val _state = MutableStateFlow(ContactState())
    val state = combine(_state, _sortType, _contacts) { state, sortType, contacts ->
        state.copy(
            contacts = contacts,
            sortType = sortType
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), ContactState())

    fun onEvent(event: ContactEvent) {
        when (event) {
            is ContactEvent.DeleteContact -> {
                viewModelScope.launch {
                    dao.deleteContact(event.contact)
                }
            }

            ContactEvent.HideDialog -> {
                _state.update {
                    it.copy(
                        isAddingContact = false
                    )
                }
            }

            ContactEvent.SaveContact -> {

                val dosis = state.value.dosis
                val obat = state.value.obat
                val hour = state.value.hour
                val minute = state.value.minute
                val jenis = state.value.jenis



                if (dosis.isBlank() || obat.isBlank()) {
                    return
                }

                val contact = Contact(
                    dosis = dosis,
                    obat = obat,
                    hour = hour,
                    minute = minute,
                    jenis = jenis,
                )

                viewModelScope.launch {
                    dao.upsertContact(contact)
                }

                _state.update {
                    it.copy(
                        isAddingContact = false,
                        dosis = "",
                        obat = "",
                        hour = 0,
                        minute = 0,
                        jenis = ""
                    )
                }
            }

            is ContactEvent.SetDosis -> {
                _state.update {
                    it.copy(
                        dosis = event.dosis
                    )
                }
            }

            is ContactEvent.SetObat -> {
                _state.update {
                    it.copy(
                        obat = event.obat
                    )
                }
            }

            is ContactEvent.SetHour -> {
                _state.update {
                    it.copy(
                        hour = event.hour
                    )
                }
            }

            is ContactEvent.SetMinute -> {
                _state.update {
                    it.copy(
                        minute = event.minute
                    )
                }
            }

            is ContactEvent.SetJenis -> {
                _state.update {
                    it.copy(
                        jenis = event.jenis
                    )
                }
            }

            ContactEvent.ShowDialog -> {
                _state.update {
                    it.copy(
                        isAddingContact = true
                    )
                }
            }

            is ContactEvent.SortContacts -> {
                _sortType.value = event.sortType
            }

            else -> {}
        }
    }
}