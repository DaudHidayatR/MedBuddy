package com.google.watermelonmigrasi.alarms

import androidx.room.Database
import androidx.room.RoomDatabase
import com.google.watermelonmigrasi.alarms.Contact
import com.google.watermelonmigrasi.alarms.ContactDao

@Database(
    entities = [Contact::class],
    version = 1
)
abstract class ContactDatabase: RoomDatabase() {

    abstract val dao: ContactDao
}