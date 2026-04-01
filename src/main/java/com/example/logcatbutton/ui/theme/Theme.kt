package com.example.logcatbutton.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = PrimaryBlue,
    secondary = SecondaryBlue,
    background = BackgroundLight
)

private val LightColorScheme = lightColorScheme(
    primary = PrimaryBlue,
    secondary = SecondaryBlue,
    background = BackgroundLight
)

@Composable
fun LogcatButtonTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context)
            else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

// CORES DOS BOTÕES (ok agora)
@Composable
fun DebugButtonColors() =
    ButtonDefaults.buttonColors(containerColor = SuccessGreen)

@Composable
fun WarningButtonColors() =
    ButtonDefaults.buttonColors(containerColor = WarningOrange)

@Composable
fun ErrorButtonColors() =
    ButtonDefaults.buttonColors(containerColor = ErrorRed)

@Composable
fun InfoButtonColors() =
    ButtonDefaults.buttonColors(containerColor = InfoPurple)