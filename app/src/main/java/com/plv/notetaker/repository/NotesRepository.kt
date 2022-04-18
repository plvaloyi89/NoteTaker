package com.plv.notetaker.repository

import androidx.lifecycle.LiveData
import com.plv.notetaker.data.Note
import com.plv.notetaker.data.NoteDao

class NotesRepository (val notes: NoteDao){

    val getNotes : LiveData<List<Note>> = notes.getAllNotes()

    suspend fun addNote( note : Note){
        notes.addNote(note)
    }
}