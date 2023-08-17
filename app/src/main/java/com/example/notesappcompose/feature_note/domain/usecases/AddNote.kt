package com.example.notesappcompose.feature_note.domain.usecases

import com.example.notesappcompose.feature_note.domain.model.InvalidNoteException
import com.example.notesappcompose.feature_note.domain.model.Note
import com.example.notesappcompose.feature_note.domain.repository.NoteRepository

class AddNote(
    private val repository: NoteRepository
) {
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("Title of the Note can't be Empty!")
        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("Content of the Note can't be Empty!")
        }

        //If the above two conditions don't meet, then we can insert the note
        repository.insertNote(note)
    }
}