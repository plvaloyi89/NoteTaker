package com.plv.notetaker.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.plv.notetaker.R
import com.plv.notetaker.data.Note
import com.plv.notetaker.viewModels.NotesViewModel

class addNote : AppCompatActivity() {

    private lateinit var viewModel : NotesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        viewModel = ViewModelProvider(this).get(NotesViewModel::class.java)

        findViewById<Button>(R.id.submit).setOnClickListener {
            insertNote()
        }

    }

    private fun insertNote() {
        val title = findViewById<EditText>(R.id.addNoteTitle).text.toString()
        val date = findViewById<EditText>(R.id.addNoteDate).text.toString()
        val notes = findViewById<EditText>(R.id.addNotes).text.toString()

        if (validateInput(title,date,notes)){
            val note = Note(0,title, date, notes)
            viewModel.addNote(note)
            Toast.makeText(this,"Task has been added", Toast.LENGTH_LONG).show()
        } else{
            Toast.makeText(this,"Failed to add task", Toast.LENGTH_LONG).show()
        }


    }
    private fun validateInput(title:String,date:String,note:String):Boolean{
        return !(TextUtils.isEmpty(title) && TextUtils.isEmpty(date) && TextUtils.isEmpty(note))
    }
}