package com.plv.notetaker.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.plv.notetaker.R
import com.plv.notetaker.data.Note
import com.plv.notetaker.view.UpdateNote

class NotesAdapter : RecyclerView.Adapter<NotesViewHolder>() {

    private var noteList = emptyList<Note>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
       val layoutInflater =LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.notelistlayout,parent,false)
        return NotesViewHolder(cellForRow)
    }

    override fun getItemCount(): Int = noteList.size

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val result = noteList[position]
       holder.view.findViewById<TextView>(R.id.noteTitle).text = result.title
        holder.view.findViewById<TextView>(R.id.noteDate).text = result.date
        
    }

    fun setData(notes : List<Note>){
        this.noteList = notes
        notifyDataSetChanged()
    }
}