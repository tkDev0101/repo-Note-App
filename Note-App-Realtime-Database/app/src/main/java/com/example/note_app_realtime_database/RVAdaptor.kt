package com.example.note_app_realtime_database

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions


class RVAdaptor(options: FirebaseRecyclerOptions<Note>) : FirebaseRecyclerAdapter<Note, RVAdaptor.RVViewHolder>(

    options

) {
    // Now set up the recyclerView in MainActivity

    class RVViewHolder(itemView: android.view.View) : RecyclerView.ViewHolder(itemView) {

        val noteText: TextView = itemView.findViewById(R.id.noteText)
    }

    // Delete a note
    fun deleteNote(position: Int) {
        getRef(position).removeValue()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVViewHolder {
        return RVViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false))
    }

    override fun onBindViewHolder(holder: RVViewHolder, position: Int, model: Note) {
        holder.noteText.text = model.text
    }
}