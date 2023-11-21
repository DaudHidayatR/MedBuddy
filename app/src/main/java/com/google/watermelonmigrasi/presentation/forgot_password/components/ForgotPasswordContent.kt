package com.google.watermelonmigrasi.presentation.forgot_password.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.sp
import com.google.watermelonmigrasi.components.EmailField
import com.google.watermelonmigrasi.components.SmallSpacer
import com.google.watermelonmigrasi.core.Constants.EMPTY_STRING
import com.google.watermelonmigrasi.core.Constants.RESET_PASSWORD_BUTTON

@Composable
fun ForgotPasswordContent(
    padding: PaddingValues,
    sendPasswordResetEmail: (email: String) -> Unit,
) {
    var email by rememberSaveable(
        stateSaver = TextFieldValue.Saver,
        init = {
            mutableStateOf(
                value = TextFieldValue(
                    text = EMPTY_STRING
                )
            )
        }
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EmailField(
            email = email,
            onEmailValueChange = { newValue ->
                email = newValue
            }
        )
        SmallSpacer()
        Button(
            onClick = {
                sendPasswordResetEmail(email.text)
            }
        ) {
            Text(
                text = RESET_PASSWORD_BUTTON,
                fontSize = 15.sp
            )
        }
    }
}