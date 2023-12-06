package com.example.notesappcompose.feature_note.navigation

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.notesappcompose.feature_note.presentation.add_edit_note.AddEditScreenUI
import com.example.notesappcompose.feature_note.presentation.notes.NotesScreen

@Composable
fun AppNavHost() {
    Surface(color = MaterialTheme.colorScheme.background) {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = NavScreen.NotesScreen.route
        ) {
            composable(route = NavScreen.NotesScreen.route) {
                NotesScreen(navController = navController, LocalContext.current)

            }

            composable(
                route = NavScreen.AddEditNoteScreen.route,
                arguments = listOf(
                    navArgument(name = "noteId") {
                        type = NavType.IntType
                        defaultValue = -1
                    },

                    navArgument(name = "noteColor") {
                        type = NavType.IntType
                        defaultValue = -1
                    },
                )
            ) {
                val color = it.arguments?.getInt("noteColor") ?: -1
                AddEditScreenUI(navController = navController, noteColor = color)
            }

        }
    }

}