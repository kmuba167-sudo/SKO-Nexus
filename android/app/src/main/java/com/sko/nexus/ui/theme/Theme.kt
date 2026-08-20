package com.sko.nexus.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.sko.nexus.core.ui.theme.SkoBackground
import com.sko.nexus.core.ui.theme.SkoBlue
import com.sko.nexus.core.ui.theme.SkoBlueLight
import com.sko.nexus.core.ui.theme.SkoError
import com.sko.nexus.core.ui.theme.SkoNavy
import com.sko.nexus.core.ui.theme.SkoSuccess

private val LightColorScheme = lightColorScheme(
    primary = SkoBlue,
    onPrimary = Color.White,

    secondary = SkoNavy,
    onSecondary = Color.White,

    tertiary = SkoBlueLight,
    onTertiary = SkoNavy,

    background = SkoBackground,
    onBackground = SkoNavy,

    surface = Color.White,
    onSurface = SkoNavy,

    error = SkoError,
    onError = Color.White
)

@Composable
fun SKONexusTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}