package com.example.notesappcompose.di

import android.app.Application
import androidx.room.Room
import com.example.notesappcompose.feature_note.data.data_source.NoteDB
import com.example.notesappcompose.feature_note.data.repository.NoteRepositoryImpl
import com.example.notesappcompose.feature_note.domain.repository.NoteRepository
import com.example.notesappcompose.feature_note.domain.usecases.AddNote
import com.example.notesappcompose.feature_note.domain.usecases.DeleteNote
import com.example.notesappcompose.feature_note.domain.usecases.GetNote
import com.example.notesappcompose.feature_note.domain.usecases.GetNotes
import com.example.notesappcompose.feature_note.domain.usecases.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDB {
        return Room.databaseBuilder(
            app,
            NoteDB::class.java,
            NoteDB.DB_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDB): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository),
            getIndividualNote = GetNote(repository)
        )
    }

}