package com.plv.notetaker.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plv.notetaker.data.Note
import com.plv.notetaker.data.NotesDatabase
import com.plv.notetaker.repository.NotesRepository
import kotlinx.coroutines.launch

class NotesViewModel(application: Application): AndroidViewModel(application) {

     val getAllNotes : LiveData<List<Note>>
     val repo : NotesRepository

    init {
        val noteDao = NotesDatabase.retreiveDatabase(application).NoteDao()
        repo = NotesRepository(noteDao)
        getAllNotes = repo.getNotes
    }

     fun addNote(note:Note){
        viewModelScope.launch {
            repo.addNote(note)
        }
    }
}