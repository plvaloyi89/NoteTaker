package com.plv.notetaker.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.versionedparcelable.VersionedParcelize

@Entity(tableName = "notes_table")
data class Note(@PrimaryKey (autoGenerate = true)val id :Int, val title:String, val date:String, var note:String){

}
