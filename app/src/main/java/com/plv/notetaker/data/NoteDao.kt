package com.plv.notetaker.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    @Query("SELECT * FROM notes_table ORDER BY id ASC")
    fun getAllNotes() : LiveData<List<Note>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)
}