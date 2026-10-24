package com.example.notesappcompose.feature_note.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import com.example.notesappcompose.feature_note.navigation.AppNavHost
import com.example.notesappcompose.ui.theme.NotesappcomposeTheme
import com.example.notesappcompose.ui.theme.ThemeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val themeViewModel: ThemeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Use the user's saved choice, otherwise follow the system setting
            val darkTheme = themeViewModel.darkThemeOverride.value ?: isSystemInDarkTheme()

            NotesappcomposeTheme(darkTheme = darkTheme) {
                AppNavHost(
                    isDarkTheme = darkTheme,
                    onToggleTheme = { themeViewModel.setDarkTheme(!darkTheme) }
                )
            }
        }
    }
}


