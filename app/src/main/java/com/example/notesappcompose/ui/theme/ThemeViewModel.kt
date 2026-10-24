package com.example.notesappcompose.ui.theme

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ThemeViewModel @Inject constructor(
    private val themePreferences: ThemePreferences
) : ViewModel() {

    // null = user hasn't picked a theme yet, so the system setting is used
    private val _darkThemeOverride = mutableStateOf(themePreferences.getDarkTheme())
    val darkThemeOverride: State<Boolean?> = _darkThemeOverride

    fun setDarkTheme(enabled: Boolean) {
        _darkThemeOverride.value = enabled
        themePreferences.setDarkTheme(enabled)
    }
}
