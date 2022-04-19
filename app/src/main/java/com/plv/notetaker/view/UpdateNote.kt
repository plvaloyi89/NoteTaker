package com.plv.notetaker.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.plv.notetaker.R
import com.plv.notetaker.data.Note
import com.plv.notetaker.viewModels.NotesViewModel

class UpdateNote : AppCompatActivity() {

    private lateinit var viewModel : NotesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_note)
        viewModel = ViewModelProvider(this).get(NotesViewModel::class.java)

        val updateTitle = findViewById<EditText>(R.id.updateNotesTitle)
        val updateDate = findViewById<EditText>(R.id.updateNotesDate)
        val updateNotes = findViewById<EditText>(R.id.updateNotes)


        val title = intent.getStringExtra("title")
        val date = intent.getStringExtra("date")
        val note = intent.getStringExtra("note")

        updateTitle.setText(title.toString(),TextView.BufferType.EDITABLE)
        updateDate.setText(date.toString(),TextView.BufferType.EDITABLE)
        updateNotes.setText(note.toString(),TextView.BufferType.EDITABLE)

        findViewById<Button>(R.id.update).setOnClickListener {
            updateDateNote()
            onBackPressed()
        }

        findViewById<Button>(R.id.delete).setOnClickListener {
            deleteNote()
            onBackPressed()
        }

    }

    private fun deleteNote() {
        val id = intent.getIntExtra("id", 0)
        val title = findViewById<EditText>(R.id.updateNotesTitle).text.toString()
        val date = findViewById<EditText>(R.id.updateNotesDate).text.toString()
        val notes = findViewById<EditText>(R.id.updateNotes).text.toString()

        val note = Note(id,title, date, notes)
        viewModel.deleteNote(note)
        Toast.makeText(this,"Note has been deleted",Toast.LENGTH_LONG).show()
    }

    private fun updateDateNote() {
        val id = intent.getIntExtra("id", 0)
        val title = findViewById<EditText>(R.id.updateNotesTitle).text.toString()
        val date = findViewById<EditText>(R.id.updateNotesDate).text.toString()
        val notes = findViewById<EditText>(R.id.updateNotes).text.toString()

        if (validateInput(title,date,notes)){
            val note = Note(id,title, date, notes)
            viewModel.updateNote(note)
            Toast.makeText(this,"Note has been added", Toast.LENGTH_LONG).show()
        } else{
            Toast.makeText(this,"Failed to update note", Toast.LENGTH_LONG).show()
        }
    }

    private fun validateInput(title:String,date:String,note:String):Boolean{
        return !(TextUtils.isEmpty(title) && TextUtils.isEmpty(date) && TextUtils.isEmpty(note))
    }
}