package com.plv.notetaker.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import com.plv.notetaker.R
import com.plv.notetaker.data.Note
import com.plv.notetaker.view.UpdateNote
import com.plv.notetaker.viewModels.NotesViewModel

class NotesAdapter : RecyclerView.Adapter<NotesViewHolder>() {

    private var noteList = emptyList<Note>()
    private lateinit var noteViewModel : NotesViewModel

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

        holder.view.setOnClickListener {
            val intent = Intent(holder.view.context,UpdateNote::class.java)
            intent.putExtra("id", result.id)
           intent.putExtra("title",result.title)
            intent.putExtra("date", result.date)
            intent.putExtra("note",result.note)
            holder.view.context.startActivity(intent)
        }


    }

    fun setData(notes : List<Note>){
        this.noteList = notes
        notifyDataSetChanged()
    }
}