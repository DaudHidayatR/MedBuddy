package com.google.watermelonmigrasi.alarms.alarm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class MyReciver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        try {
            val message = intent?.getStringExtra("EXTRA_MESSAGE")
            val service = NotifikasiService(context!!)
            if (message != null) {
                service.showNotification(message)
            }
        } catch (e: Exception) {
            Log.d("MyAlarm", "onReceive: ${e.message}")
        }
    }
}