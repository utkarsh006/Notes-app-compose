package com.example.notesappcompose.feature_note.data.data_source

import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDB : RoomDatabase() {
    abstract val noteDao: NoteDao

    companion object{
        const val DB_NAME = "notes_db"
    }
}