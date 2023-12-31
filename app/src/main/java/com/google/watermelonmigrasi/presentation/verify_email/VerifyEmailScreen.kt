package com.google.watermelonmigrasi.presentation.verify_email

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.watermelonmigrasi.components.TopBar
import com.google.watermelonmigrasi.core.Constants.EMAIL_NOT_VERIFIED_MESSAGE
import com.google.watermelonmigrasi.core.Constants.VERIFY_EMAIL_SCREEN
import com.google.watermelonmigrasi.core.Utils.Companion.showMessage
import com.google.watermelonmigrasi.presentation.bottom_nav.ButtomNavViewModel
import com.google.watermelonmigrasi.presentation.bottom_nav.RevokeAccess

import com.google.watermelonmigrasi.presentation.verify_email.components.ReloadUser
import com.google.watermelonmigrasi.presentation.verify_email.components.VerifyEmailContent

@Composable
fun VerifyEmailScreen(
    viewModel: ButtomNavViewModel = hiltViewModel(),
    navigateToProfileScreen: () -> Unit
) {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopBar(
                title = VERIFY_EMAIL_SCREEN,
                signOut = {
                    viewModel.signOut()
                },
                revokeAccess = {
                    viewModel.revokeAccess()
                }
            )
        },
        content = { padding ->
            VerifyEmailContent(
                padding = padding,
                reloadUser = {
                    viewModel.reloadUser()
                }
            )
        },
        scaffoldState = scaffoldState
    )

    ReloadUser(
        navigateToProfileScreen = {
            if (viewModel.isEmailVerified) {
                navigateToProfileScreen()
            } else {
                showMessage(context, EMAIL_NOT_VERIFIED_MESSAGE)
            }
        }
    )

    RevokeAccess(
        scaffoldState = scaffoldState,
        coroutineScope = coroutineScope,
        signOut = {
            viewModel.signOut()
        }
    )
}