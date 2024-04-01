package com.minstone.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import com.miso.design_system.theme.ColorTheme
import com.miso.design_system.theme.color.LightColor

@Composable
fun RiiidTheme(
    colors: ColorTheme = if (!isSystemInDarkTheme()) LightColor else LightColor,
    typography: MisoTypography = MisoTypography,
    content: @Composable (colors: ColorTheme, typography: MisoTypography) -> Unit
) {
    content(colors, typography)
    ApplySystemUi(isSystemInDarkTheme())
}