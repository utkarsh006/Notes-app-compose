package com.example.notesappcompose.ui.theme

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Stores the user's light/dark theme choice.
 * No value stored yet (null) means "follow the system setting".
 */
@Singleton
class ThemePreferences @Inject constructor(
    @ApplicationContext context: Context
) {
    private val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun getDarkTheme(): Boolean? =
        if (prefs.contains(KEY_DARK_THEME)) prefs.getBoolean(KEY_DARK_THEME, false) else null

    fun setDarkTheme(enabled: Boolean) {
        prefs.edit().putBoolean(KEY_DARK_THEME, enabled).apply()
    }

    private companion object {
        const val PREFS_NAME = "theme_prefs"
        const val KEY_DARK_THEME = "dark_theme"
    }
}
