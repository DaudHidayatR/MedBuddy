package com.google.watermelonmigrasi.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    background = Tan20,
    onBackground = Tan89,
    surface = Tan10,
    onSurface = Tan89,
    surfaceVariant = Orange60,
    onSurfaceVariant = Tan89,
    primary = Orange95,
    onPrimary = White,
    primaryContainer = Orange95,
    onPrimaryContainer = Orange40,
    secondaryContainer = Tan30,
    onSecondaryContainer = Tan89,
    outline = Tan70
)

private val LightColorScheme = lightColorScheme(
    background = Tan80,
    onBackground = Tan29,
    surface = Tan99,
    onSurface = Tan50,
    surfaceVariant = Tan95,
    onSurfaceVariant = Tan50,
    primary = Orange70,
    onPrimary = White,
    primaryContainer = Orange99,
    onPrimaryContainer = Tan50,
    secondaryContainer = Tan90,
    onSecondaryContainer = Tan50,
    outline = Tan65
)

@Composable
fun WatermelonMigrasiTheme(
//    darkTheme: Boolean = isSystemInDarkTheme(),
//    // Dynamic color is available on Android 12+
//    dynamicColor: Boolean = true,
//    content: @Composable () -> Unit
//) {
//    val colorScheme = when {
//        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//            val context = LocalContext.current
//            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
//        }
//
//        darkTheme -> DarkColorScheme
//        else -> LightColorScheme
//    }
//    val view = LocalView.current
//    if (!view.isInEditMode) {
//        SideEffect {
//            val window = (view.context as Activity).window
//            window.statusBarColor = colorScheme.primary.toArgb()
//            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
//        }
//    }
//
//    MaterialTheme(
//        colorScheme = colorScheme,
//        typography = Typography,
//        content = content,
//        shapes = Shapes
//    )
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (!useDarkTheme) {
        LightColorScheme
    } else {
        DarkColorScheme
    }

    MaterialTheme(
        colorScheme = colors,
        content = content,
        shapes = Shapes,
        typography = Typography
    )
}