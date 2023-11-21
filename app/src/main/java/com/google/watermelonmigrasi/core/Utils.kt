package com.google.watermelonmigrasi.core

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.google.watermelonmigrasi.core.Constants.TAG

class Utils {
    companion object {
        fun print(e: Exception) = Log.e(TAG, e.stackTraceToString())

        fun showMessage(
            context: Context,
            message: String?
        ) = Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}