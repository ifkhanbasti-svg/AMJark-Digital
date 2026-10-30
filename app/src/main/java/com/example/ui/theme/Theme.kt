package com.example.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val AmjarkDarkColorScheme = darkColorScheme(
  primary = ElectricBlue,
  onPrimary = MainBackground,
  primaryContainer = PrimaryBlue,
  onPrimaryContainer = MainText,
  secondary = ElectricBlue,
  onSecondary = MainBackground,
  secondaryContainer = SecondaryBackground,
  onSecondaryContainer = MainText,
  tertiary = AccentCyan,
  onTertiary = MainBackground,
  background = MainBackground,
  onBackground = MainText,
  surface = CardBackground,
  onSurface = MainText,
  surfaceVariant = SecondaryBackground,
  onSurfaceVariant = SecondaryText,
  outline = CardBorder,
  outlineVariant = CardBorderHover
)

@Composable
fun MyApplicationTheme(
  darkTheme: Boolean = true, // AMJark Digital is a dedicated luxury dark-themed corporate experience
  dynamicColor: Boolean = false, // Keep corporate brand identity intact
  content: @Composable () -> Unit
) {
  val colorScheme = AmjarkDarkColorScheme
  val view = LocalView.current
  if (!view.isInEditMode) {
    SideEffect {
      val window = (view.context as? Activity)?.window
      if (window != null) {
        window.statusBarColor = MainBackground.toArgb()
        window.navigationBarColor = MainBackground.toArgb()
        val insetsController = WindowCompat.getInsetsController(window, view)
        insetsController.isAppearanceLightStatusBars = false
        insetsController.isAppearanceLightNavigationBars = false
      }
    }
  }

  MaterialTheme(
    colorScheme = colorScheme,
    typography = Typography,
    content = content
  )
}
