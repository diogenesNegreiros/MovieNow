package com.mobilemaker.movienow.ui.theme


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = Red,
    onPrimary = White,
    background = Black,
    onBackground = LightGray,
    surface = Black,
    onSurface = Gray
)

@Composable
fun MovieAppTheme(
    darkTheme: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme || isSystemInDarkTheme()) {
        DarkColorScheme
    } else {
        DarkColorScheme // Sempre tema escuro, mas você pode definir LightColorScheme se quiser
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography, // opcional, se tiver um Typography.kt
        content = content
    )
}
