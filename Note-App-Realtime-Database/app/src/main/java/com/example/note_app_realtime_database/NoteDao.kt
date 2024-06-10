package com.example.note_app_realtime_database

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class NoteDao {

    private val db: DatabaseReference = FirebaseDatabase.getInstance().reference.child("Notes") // get db reference
    private val auth: FirebaseAuth = FirebaseAuth.getInstance() // get auth instance

    fun addNote(text: String) {
        val currentUserId = auth.currentUser!!.uid
        val noteId = db.push().key // generate unique key for the note
        val note = Note(noteId, text, currentUserId)

        if (noteId != null) {
            db.child(noteId).setValue(note)
        }
    }




}