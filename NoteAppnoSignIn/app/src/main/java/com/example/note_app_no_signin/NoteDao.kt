package com.example.note_app_no_signin

import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreKtxRegistrar

class NoteDao {

    private val db = FirebaseFirestore.getInstance() //get db instance
    val noteCollection = db.collection("Notes") //create notes collections
    //we also need auth for currentUserId
    private val auth = Firebase.auth
    //private val auth = FirebaseAuth.getInstance()
    //auth = Firebase.auth
    fun addNote(text: String){
        val currentUserId = auth.currentUser!!.uid
        val note = Note(text, currentUserId)
        //val note = Note(text)
        noteCollection.document().set(note)
    }

}