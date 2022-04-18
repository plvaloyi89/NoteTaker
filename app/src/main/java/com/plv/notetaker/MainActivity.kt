package com.plv.notetaker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.plv.notetaker.adapters.NotesAdapter
import com.plv.notetaker.data.Note
import com.plv.notetaker.view.addNote
import com.plv.notetaker.viewModels.NotesViewModel

class MainActivity : AppCompatActivity() {

     lateinit var noteList : RecyclerView
     private lateinit var noteViewModel : NotesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = NotesAdapter()
        noteList = findViewById(R.id.recyclerView)
        noteList.addItemDecoration(DividerItemDecoration(noteList.context,DividerItemDecoration.VERTICAL))
        noteList.adapter = adapter
        noteList.layoutManager = LinearLayoutManager(applicationContext)

        noteViewModel = ViewModelProvider(this).get(NotesViewModel::class.java)
        noteViewModel.getAllNotes.observe(this, Observer { Note ->
            adapter.setData(Note)

        })

        findViewById<FloatingActionButton>(R.id.addNote).setOnClickListener {
            val intent = Intent(this,addNote::class.java)
            startActivity(intent)
        }
    }
}