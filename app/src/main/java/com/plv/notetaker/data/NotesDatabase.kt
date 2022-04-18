package com.plv.notetaker.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NotesDatabase : RoomDatabase() {

    abstract fun NoteDao():NoteDao

    companion object{
        @Volatile
        private var INSTANCE : NotesDatabase? = null

        @OptIn(InternalCoroutinesApi::class)
        fun retreiveDatabase(context : Context):NotesDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,
                    NotesDatabase::class.java,
                    "notes_database").build()
                INSTANCE = instance
                return instance
            }
        }

    }
}